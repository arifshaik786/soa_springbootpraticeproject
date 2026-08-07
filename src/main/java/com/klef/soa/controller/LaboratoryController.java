package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Laboratory;
import com.klef.soa.service.LaboratoryService;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController
{
    @Autowired
    private LaboratoryService service;

    @GetMapping("/")
    public String test()
    {
        return "Laboratory Controller is Working";
    }

    // Add Laboratory
    @PostMapping("/add")
    public ResponseEntity<Laboratory> addLaboratory(@RequestBody Laboratory laboratory)
    {
        Laboratory lab = service.addLaboratory(laboratory);
        BodyBuilder builder = ResponseEntity.status(HttpStatus.CREATED);
        return builder.body(lab);
    }

    // Display All Laboratories
    @GetMapping("/displayall")
    public ResponseEntity<List<Laboratory>> displayAllLaboratories()
    {
        List<Laboratory> laboratories = service.displayAllLaboratories();
        return ResponseEntity.status(HttpStatus.OK).body(laboratories);
    }

    // Display Laboratory By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayLaboratoryById(@RequestParam Long id)
    {
        Laboratory laboratory = service.displayLaboratoryById(id);

        if(laboratory != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(laboratory);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Laboratory ID Not Found");
        }
    }

    // Update Laboratory
    @PutMapping("/update")
    public ResponseEntity<?> updateLaboratory(@RequestBody Laboratory laboratory)
    {
        Laboratory lab = service.updateLaboratory(laboratory);

        if(lab != null)
        {
            return ResponseEntity.ok(lab);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Laboratory ID Not Found");
        }
    }

    // Delete Laboratory
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLaboratoryById(@PathVariable Long id)
    {
        String message = service.deleteLaboratoryById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Display Laboratories By Name
    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Laboratory>> displayLaboratoriesByName(@PathVariable String name)
    {
        List<Laboratory> laboratories = service.displayLaboratoryByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(laboratories);
    }

    // Display Laboratories By Type
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Laboratory>> displayLaboratoriesByType(@PathVariable String type)
    {
        List<Laboratory> laboratories = service.displayLaboratoryByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(laboratories);
    }

    // Display Laboratories By City
    @GetMapping("/displaybycity/{city}")
    public ResponseEntity<List<Laboratory>> displayLaboratoriesByCity(@PathVariable String city)
    {
        List<Laboratory> laboratories = service.displayLaboratoryByCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(laboratories);
    }

    // Display Laboratory Count
    @GetMapping("/count")
    public ResponseEntity<String> displayLaboratoryCount()
    {
        Long count = service.displayLaboratoryCount();
        String msg = "Total Laboratories = " + count;
        return ResponseEntity.ok(msg);
    }
}