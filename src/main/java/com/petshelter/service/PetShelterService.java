package com.petshelter.service;

import com.petshelter.model.Pet;
import com.petshelter.model.Adopter;
import com.petshelter.model.PetShelter;

public class PetShelterService {

    private PetShelter petShelter;
    private PetService petService;
    private AdopterService adopterService;

    public PetShelterService(PetShelter petShelter, PetService petService, AdopterService adopterService) {
        this.petShelter = petShelter;
        this.petService = petService;
        this.adopterService = adopterService;
    }

    public void addPet(Pet pet) {
        petShelter.addPet(pet);
        System.out.println(pet.getName() + " has been added to " + petShelter.getName() + ".");
    }

    public void listAvailablePets() {
        if (petShelter.getAvailablePets().isEmpty()) {
            System.out.println("No pets available for adoption or fostering.");
        } else {
            System.out.println("Available pets at " + petShelter.getName() + ":");
            for (Pet pet : petShelter.getAvailablePets()) {
                if (!pet.isAdopted() && !pet.isFostered()) {
                    System.out.println(pet);
                }
            }
        }
    }

    public boolean adoptPet(Adopter adopter, Pet pet) {
        if (petShelter.getAvailablePets().contains(pet) && !pet.isAdopted() && !pet.isFostered()) {
            boolean adoptionSuccessful = adopterService.adoptPet(adopter,pet);
            if (adoptionSuccessful) {
                petService.markAsAdopted(pet);
                petShelter.removePet(pet);
                System.out.println(adopter.getName() + " has adopted " + pet.getName() + "!");
                return true;
            }
        } else {
            System.out.println(pet.getName() + " is not available for adoption.");
        }
        return false;
    }

    public boolean fosterPet(Adopter adopter, Pet pet) {
        if (petShelter.getAvailablePets().contains(pet) && !pet.isAdopted() && !pet.isFostered()) {
            boolean fosteringSuccessful = adopterService.fosterPet(adopter,pet);
            if (fosteringSuccessful) {
                petService.markAsFostered(pet);
                petShelter.removePet(pet);
                System.out.println(adopter.getName() + " is now fostering " + pet.getName() + "!");
                return true;
            }
        } else {
            System.out.println(pet.getName() + " is not available for fostering.");
        }
        return false;
    }

    public boolean returnFosteredPet(Adopter adopter, Pet pet) {
        if (adopter.getFosteredPets().contains(pet)) {
            boolean returnFosterSuccessful = adopterService.returnFosteredPet(adopter,pet);
            if (returnFosterSuccessful) {
                petService.returnFromFostering(pet);
                petShelter.addPet(pet);
                System.out.println(pet.getName() + " has been returned from foster care.");
                return true;
            }
        } else {
            System.out.println(pet.getName() + " is not in foster care.");
        }
        return false;
    }

}
