package com.petshelter;

import com.petshelter.model.Pet;
import com.petshelter.model.Adopter;
import com.petshelter.model.PetShelter;

import com.petshelter.service.AdopterService;
import com.petshelter.service.PetService;
import com.petshelter.service.PetShelterService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShelterTest {

    private PetShelter petShelter;
    private PetShelterService petShelterService;
    private Pet pet1;
    private Pet pet2;
    private PetService petService;
    private Adopter adopter;
    private AdopterService adopterService;

    @BeforeEach
    void setUp() {
        petShelter = new PetShelter("Angie's Paw Angels");
        petService = Mockito.mock(PetService.class);
        adopterService = Mockito.mock(AdopterService.class);
        petShelterService = new PetShelterService(petShelter,petService,adopterService);

        pet1 = new Pet("Snickers", "Cat", "Ragdoll", 2);
        pet2 = new Pet("Waldo","Dog","Boston Terrier",5);
        adopter = new Adopter("Lady Gaga","800-867-5309");
    }

    @Test
    void testAddPet() {
        petShelterService.addPet(pet1);
        assertTrue(petShelter.getAvailablePets().contains(pet1));
    }

    @Test
    void testListAvailablePets() {
        petShelter.addPet(pet1);
        petShelter.addPet(pet2);

        petShelterService.listAvailablePets();
        assertEquals(2, petShelter.getAvailablePets().size());
    }

    @Test
    void testFosterPet() {
        petShelter.addPet(pet1);
        petShelterService.fosterPet(adopter,pet1);

        verify(adopterService, times(1)).fosterPet(adopter,pet1);
    }

    @Test
    void testReturnFosterPet() {
        adopter.getFosteredPets().add(pet2);

        petShelterService.returnFosteredPet(adopter,pet2);

        verify(adopterService, times(1)).returnFosteredPet(adopter,pet2);
    }

}
