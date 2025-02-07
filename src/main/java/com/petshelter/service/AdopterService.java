package com.petshelter.service;

import com.petshelter.model.Adopter;
import com.petshelter.model.Pet;

public class AdopterService {

    private final PetService petservice;

    public AdopterService(PetService petService) {
        this.petservice = petService;
    }

    public boolean adoptPet(Adopter adopter, Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            petservice.markAsAdopted(pet);
            adopter.getAdoptedPets().add(pet);
            return true;
        } else {
            return false;
        }
    }

    public boolean fosterPet(Adopter adopter, Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            petservice.markAsFostered(pet);
            if (!adopter.getFosteredPets().contains(pet)) {
                adopter.getFosteredPets().add(pet);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean returnFosteredPet(Adopter adopter, Pet pet) {
        if (adopter.getFosteredPets().contains(pet)) {
            petservice.returnFromFostering(pet);
            adopter.getFosteredPets().remove(pet);
            return true;
        } else {
            return false;
        }
    }

}
