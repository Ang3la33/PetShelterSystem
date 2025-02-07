package com.petshelter.service;

import com.petshelter.model.Pet;

public class PetService {

    public void adoptPet(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setAdopted(true);
            System.out.println(pet.getName() + " has been adopted!");
        } else {
            System.out.println(pet.getName() + " is not available for adoption.");
        }
    }

    public void fosterPet(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setFostered(true);
            System.out.println(pet.getName() + " is now in foster care!");
        } else {
            System.out.println(pet.getName() + " is not available for fostering.");
        }
    }

    public void returnFosteredPet(Pet pet) {
        if (pet.isFostered()) {
            pet.setFostered(false);
            System.out.println(pet.getName() + " has been returned from foster care.");
        } else {
            System.out.println(pet.getName() + " is not currently in foster care.");
        }
    }

}
