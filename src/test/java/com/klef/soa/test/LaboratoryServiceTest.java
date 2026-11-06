
package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.klef.soa.entity.Laboratory;
import com.klef.soa.repository.LaboratoryRepository;
import com.klef.soa.service.LaboratoryServiceImpl;

@ExtendWith(MockitoExtension.class)

public class LaboratoryServiceTest
{
    @Mock
    private LaboratoryRepository repo;

    @InjectMocks
    private LaboratoryServiceImpl service;


    // TEST CASE 4: Add Laboratory

    @Test
    void testAddLaboratory()
    {
        Laboratory lab = new Laboratory();

        lab.setName("Computer Lab");
        lab.setType("Computer");
        lab.setCity("Vijayawada");

        when(repo.save(lab)).thenReturn(lab);

        Laboratory result = service.addLaboratory(lab);

        assertNotNull(result);
        assertEquals("Computer Lab", result.getName());
        assertEquals("Computer", result.getType());
        assertEquals("Vijayawada", result.getCity());

        verify(repo).save(lab);

        System.out.println("TC-4: Add Laboratory PASSED");
        System.out.println("Laboratory Name: " + result.getName());
    }


    // TEST CASE 5: Display All Laboratories

    @Test
    void testDisplayAllLaboratories()
    {
        Laboratory lab1 = new Laboratory();
        lab1.setName("Computer Lab");
        lab1.setType("Computer");
        lab1.setCity("Vijayawada");

        Laboratory lab2 = new Laboratory();
        lab2.setName("Physics Lab");
        lab2.setType("Physics");
        lab2.setCity("Guntur");

        List<Laboratory> labs = Arrays.asList(lab1, lab2);

        when(repo.findAll()).thenReturn(labs);

        List<Laboratory> result =
                service.displayAllLaboratories();

        assertNotNull(result);
        assertEquals(2, result.size());

        verify(repo).findAll();

        System.out.println("TC-5: Display All Laboratories PASSED");
        System.out.println("Total Laboratories: " + result.size());
    }
}
