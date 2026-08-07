package com.klef.soa.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryDTO
{
    private Long laboratoryId;
    private String name;
    private String type;
    private String city;
    private int capacity;
    private LocalTime openingTime;
    private LocalTime closingTime;
}