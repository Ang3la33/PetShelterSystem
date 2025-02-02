package com.petshelter;

import com.petshelter.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("MacGyver","Dog","Rottweiler", 9);
    }

    @Test
    void testInitialPetState() {
        assertEquals("MacGyver",pet.getName());
        assertEquals("Dog", pet.getSpecies());
        assertEquals("Rottweiler", pet.getBreed());
        assertEquals(9, pet.getAge());
        assertFalse(pet.isAdopted());
        assertFalse(pet.isFostered());
    }

    @Test
    void testAdoptPet() {
        pet.setAdopted(true);
        assertTrue(pet.isAdopted());
    }

    @Test
    void testFosterPet() {
        pet.setFostered(true);
        assertTrue(pet.isFostered());
    }

}
