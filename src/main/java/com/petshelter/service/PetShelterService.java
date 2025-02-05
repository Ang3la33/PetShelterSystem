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

    public void adoptPet(Adopter adopter, Pet pet) {
        if (petShelter.getAvailablePets().contains(pet) && !pet.isAdopted() && !pet.isFostered()) {
            adopterService.adoptPet(adopter, pet);
            petShelter.removePet(pet);
        } else {
            System.out.println(pet.getName() + " is not available for adoption.");
        }
    }

    public void fosterPet(Adopter adopter, Pet pet) {
        if (petShelter.getAvailablePets().contains(pet) && !pet.isAdopted() && !pet.isFostered()) {
            adopterService.fosterPet(adopter, pet);
        } else {
            System.out.println(pet.getName() + " is not available for fostering.");
        }
    }

    public void returnFosteredPet(Adopter adopter, Pet pet) {
        if (adopter.getFosteredPets().contains(pet)) {
            adopterService.returnFosteredPet(adopter, pet);
            petShelter.addPet(pet);
        } else {
            System.out.println(pet.getName() + " is not in foster care.");
        }
    }

}
