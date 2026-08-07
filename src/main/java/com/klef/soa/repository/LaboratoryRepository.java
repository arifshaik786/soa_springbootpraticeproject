package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long>
{
    // Derived Query Method 1
    List<Laboratory> findByName(String name);

    // Derived Query Method 2
    List<Laboratory> findByType(String type);
    
    List<Laboratory> findByCity(String city);
}