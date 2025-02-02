package com.petshelter.service;

import com.petshelter.model.Adopter;
import com.petshelter.model.Pet;

public class AdopterService {

    public void adoptPet(Adopter adopter, Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setAdopted(true);
            adopter.getAdoptedPets().add(pet);
            System.out.println(adopter.getName() + " has adopted " + pet.getName() + ".");
        } else {
            System.out.println("Sorry, " + pet.getName() + " is not available for adoption.");
        }
    }

    public void fosterPet(Adopter adopter, Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setFostered(true);
            adopter.getFosteredPets().add(pet);
            System.out.println(adopter.getName() + " is fostering " + pet.getName() + ".");
        } else {
            System.out.println("Sorry, " + pet.getName() + " is not available for fostering.");
        }
    }
}
