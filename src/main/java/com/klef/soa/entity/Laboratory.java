package com.klef.soa.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Laboratory_table")
@Data
 
public class Laboratory 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "laboratory_id")
   private Long laboratoryId;
   @Column(name = "lab_name", length = 100, nullable = false)
   private String name;
   @Column(name = "lab_type", length = 50, nullable = false)
   private String type;
   @Column(length = 100, nullable = false)
   private String city;
   @Column(nullable = false)
   private int capacity;
   @Column(name = "lab_status", length = 30, nullable = false)
   private String status;
   @Column(name = "location", length = 100, nullable = false)
   private String location;
   @Column(name = "opening_time", nullable = false)
   private LocalTime openingTime;

   @Column(name = "closing_time", nullable = false)
   private LocalTime closingTime;
   @CreationTimestamp
   private LocalDateTime createdAt;
   @UpdateTimestamp
   private LocalDateTime updatedAt;
   
   
	
	
}
