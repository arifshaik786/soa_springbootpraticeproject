
package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Laboratory;
import com.klef.soa.repository.LaboratoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LaboratoryRepositoryTest
{
    @Autowired
    private LaboratoryRepository repository;

    // TEST CASE 1: Find Laboratory By Name

    @Test
    void testFindByName()
    {
        Laboratory lab = new Laboratory();
        lab.setName("JUnit Computer Lab");
        lab.setType("Computer");
        lab.setCity("Vijayawada");

        repository.save(lab);

        List<Laboratory> labs =
                repository.findByName("JUnit Computer Lab");

        assertNotNull(labs);
        assertFalse(labs.isEmpty());
        assertEquals("JUnit Computer Lab", labs.get(0).getName());

        System.out.println("TC-1: Find By Name PASSED");
        System.out.println("Laboratory Name: " + labs.get(0).getName());
    }


    // TEST CASE 2: Find Laboratory By Type

    @Test
    void testFindByType()
    {
        Laboratory lab = new Laboratory();
        lab.setName("JUnit Physics Lab");
        lab.setType("Physics");
        lab.setCity("Guntur");

        repository.save(lab);

        List<Laboratory> labs =
                repository.findByType("Physics");

        assertNotNull(labs);
        assertFalse(labs.isEmpty());
        assertEquals("Physics", labs.get(0).getType());

        System.out.println("TC-2: Find By Type PASSED");
        System.out.println("Laboratory Type: " + labs.get(0).getType());
    }


    // TEST CASE 3: Find Laboratory By City

    @Test
    void testFindByCity()
    {
        Laboratory lab = new Laboratory();
        lab.setName("JUnit Chemistry Lab");
        lab.setType("Chemistry");
        lab.setCity("Vijayawada");

        repository.save(lab);

        List<Laboratory> labs =
                repository.findByCity("Vijayawada");

        assertNotNull(labs);
        assertFalse(labs.isEmpty());
        assertEquals("Vijayawada", labs.get(0).getCity());

        System.out.println("TC-3: Find By City PASSED");
        System.out.println("Laboratory City: " + labs.get(0).getCity());
    }
}
