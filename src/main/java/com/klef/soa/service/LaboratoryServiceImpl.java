package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Laboratory;
import com.klef.soa.repository.LaboratoryRepository;

@Service
public class LaboratoryServiceImpl implements LaboratoryService
{
    @Autowired
    private LaboratoryRepository repo;

    @Override
    public Laboratory addLaboratory(Laboratory laboratory)
    {
        return repo.save(laboratory);
    }

    @Override
    public List<Laboratory> displayAllLaboratories()
    {
        return repo.findAll();
    }

    @Override
    public Laboratory updateLaboratory(Laboratory laboratory)
    {
        Optional<Laboratory> optional = repo.findById(laboratory.getLaboratoryId());

        if(optional.isPresent())
        {
            Laboratory lab = optional.get();

            lab.setName(laboratory.getName());
            lab.setType(laboratory.getType());
            lab.setStatus(laboratory.getStatus());
            lab.setLocation(laboratory.getLocation());
            lab.setCity(laboratory.getCity());
            lab.setCapacity(laboratory.getCapacity());
            lab.setOpeningTime(laboratory.getOpeningTime());
            lab.setClosingTime(laboratory.getClosingTime());

            return repo.save(lab);
        }
        else
        {
            return null;
        }
    }

    @Override
    public Laboratory displayLaboratoryById(Long laboratoryId)
    {
        return repo.findById(laboratoryId).orElse(null);
    }

    @Override
    public String deleteLaboratoryById(Long laboratoryId)
    {
        boolean status = repo.existsById(laboratoryId);

        if(status)
        {
            repo.deleteById(laboratoryId);
            return "Laboratory deleted successfully";
        }
        else
        {
            return "Laboratory ID Not Found";
        }
    }

    @Override
    public List<Laboratory> displayLaboratoryByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List<Laboratory> displayLaboratoryByType(String type)
    {
        return repo.findByType(type);
    }

    @Override
    public List<Laboratory> displayLaboratoryByCity(String city)
    {
        return repo.findByCity(city);
    }

    @Override
    public Long displayLaboratoryCount()
    {
        return repo.count();
    }
}