package com.petshelter.service;

import com.petshelter.model.Pet;

public class PetService {

    public void markAsAdopted(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setAdopted(true);
        }
    }

    public void markAsFostered(Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            pet.setFostered(true);
        }
    }

    public void returnFromFostering(Pet pet) {
        if (pet.isFostered()) {
            pet.setFostered(false);
        }
    }

}