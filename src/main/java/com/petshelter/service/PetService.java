package com.petshelter.service;

import com.petshelter.model.Pet;

public class PetService {

    public void adoptPet(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setAdopted(true);
            System.out.println(pet.getName() + " has been adopted!");
        } else if (pet.isFostered()) {
            System.out.println(pet.getName() + " is currently being fostered and cannot be adopted.");
        } else {
            System.out.println(pet.getName() + " is already adopted");
        }
    }

    public void fosterPet(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setFostered(true);
            System.out.println(pet.getName() + " is now being fostered.");
        } else if (pet.isAdopted()) {
            System.out.println(pet.getName() + " has already been adopted and cannot be fostered.");
        } else {
            System.out.println(pet.getName() + " is already being fostered.");
        }
    }

    public void returnFromFoster(Pet pet) {
        if (pet.isFostered()) {
            pet.setFostered(false);
            System.out.println(pet.getName() + " has been returned from foster care.");
        } else {
            System.out.println(pet.getName() + " is not currently in foster care.");
        }
    }

}
