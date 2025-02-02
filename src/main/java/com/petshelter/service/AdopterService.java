package com.petshelter.service;

import java.util.List;
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

    public void returnFosterPet(Adopter adopter, Pet pet) {
        List<Pet> fosteredPets = adopter.getFosteredPets();
        if (fosteredPets.contains(pet)) {
            pet.setFostered(false);
            fosteredPets.remove(pet);
            System.out.println(adopter.getName() + " has returned " + pet.getName() + ".");
        } else {
            System.out.println(adopter.getName() + " is not currently fostering " + pet.getName() + ".");
        }
    }

}
