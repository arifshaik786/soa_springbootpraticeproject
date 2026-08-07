package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Laboratory;

public interface LaboratoryService
{
    Laboratory addLaboratory(Laboratory laboratory);

    List<Laboratory> displayAllLaboratories();

    Laboratory updateLaboratory(Laboratory laboratory);

    Laboratory displayLaboratoryById(Long laboratoryId);

    String deleteLaboratoryById(Long laboratoryId);

    List<Laboratory> displayLaboratoryByName(String name);

    List<Laboratory> displayLaboratoryByType(String type);

    List<Laboratory> displayLaboratoryByCity(String city);

    Long displayLaboratoryCount();
}