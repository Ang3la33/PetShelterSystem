package com.petshelter;

import com.petshelter.model.Pet;
import com.petshelter.model.Adopter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AdopterTest {

    private Adopter adopter;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setUp() {
        adopter = new Adopter("Angie Smith","709-867-5309");
        pet1 = new Pet("MacGyver","Dog","Rottweiler",9);
        pet2 = new Pet("Pickles","Cat","Orange tabby",10);
    }

    @Test
    void testAdopterDetails() {
        assertEquals("Angie Smith", adopter.getName());
        assertEquals("709-867-5309", adopter.getPhoneNumber());
    }

    @Test
    void testAdoptPet() {
        adopter.getAdoptedPets().add(pet1);
        pet1.setAdopted(true);
        List<Pet> adoptedPets = adopter.getAdoptedPets();

        assertTrue(adoptedPets.contains(pet1));
        assertTrue(pet1.isAdopted());
        assertEquals(1, adoptedPets.size());
    }

    @Test
    void testFosterPet() {
        adopter.getFosteredPets().add(pet2);
        pet2.setFostered(true);
        List<Pet> fosteredPets = adopter.getFosteredPets();

        assertTrue(fosteredPets.contains(pet2));
        assertTrue(pet2.isFostered());
        assertEquals(1, fosteredPets.size());
    }

    @Test
    void testReturnFosteredPet() {
        adopter.getFosteredPets().add(pet2);
        pet2.setFostered(true);

        adopter.getFosteredPets().remove(pet2);
        pet2.setFostered(false);

        assertFalse(adopter.getFosteredPets().contains(pet2));
        assertFalse(pet2.isFostered());
    }

}
