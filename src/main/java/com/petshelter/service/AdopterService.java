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
            System.out.println(adopter.getName() + " has adopted " + pet.getName() + ".");
            return true;
        } else {
            System.out.println("Sorry, " + pet.getName() + " is not available for adoption.");
            return false;
        }
    }

    public boolean fosterPet(Adopter adopter, Pet pet) {
        if (!pet.isAdopted() && !pet.isFostered()) {
            petservice.markAsFostered(pet);
            adopter.getFosteredPets().add(pet);
            System.out.println(adopter.getName() + " is fostering " + pet.getName() + ".");
            return true;
        } else {
            System.out.println("Sorry, " + pet.getName() + " is not available for fostering.");
            return false;
        }
    }

    public boolean returnFosteredPet(Adopter adopter, Pet pet) {
        if (adopter.getFosteredPets().contains(pet)) {
            petservice.returnFromFoster(pet);
            adopter.getFosteredPets().remove(pet);
            System.out.println(adopter.getName() + " has returned " + pet.getName() + " to the shelter.");
            return true;
        } else {
            System.out.println(adopter.getName() + " is not currently fostering " + pet.getName() + ".");
            return false;
        }
    }

}
