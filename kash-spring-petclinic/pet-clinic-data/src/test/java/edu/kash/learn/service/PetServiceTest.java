package edu.kash.learn.service;


import edu.kash.learn.model.Pet;
import edu.kash.learn.service.map.PetMapService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetServiceTest {

    @Test
    public void testPet() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setPetType(null);
        PetMapService ownerMapService = new PetMapService(null);
        ownerMapService.save(pet);
        assertTrue(!ownerMapService.findAll().isEmpty());
        ownerMapService.delete(pet);
        assertTrue(ownerMapService.findAll().isEmpty());
    }
}
