package com.petshelter.model;

import java.util.ArrayList;
import java.util.List;

public class PetShelter {

    private String name;
    private List<Pet> availablePets;

    public PetShelter(String name) {
        this.name = name;
        this.availablePets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pet> getAvailablePets() {
        return availablePets;
    }

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    @Override
    public String toString() {
        return "Shelter: " + name + " | Available Pets: " + availablePets.size();
    }

}
