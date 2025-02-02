package com.petshelter.service;

import com.petshelter.model.Pet;

public class PetService {

    public void markAsAdopted(Pet pet) {
        pet.setAdopted(true);
        System.out.println(pet.getName() + " has been marked as adopted.");
    }

    public void markAsFostered(Pet pet) {
        pet.setFostered(true);
        System.out.println(pet.getName() + " is now in foster care.");
    }

    public void returnFromFoster(Pet pet) {
        pet.setFostered(false);
        System.out.println(pet.getName() + " has been returned from foster care.");
    }

}
