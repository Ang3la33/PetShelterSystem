package com.petshelter.model;

import java.util.ArrayList;
import java.util.List;

public class PetShelter {

    private String name;
    private List<Pet> availablePets;
    private List<Adopter> adopters;

    public PetShelter(String name) {
        this.name = name;
        this.availablePets = new ArrayList<>();
        this.adopters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pet> getAvailablePets() {
        return availablePets;
    }

    public List<Adopter> getAdopters() {
        return new ArrayList<>(adopters);
    }

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    public void addAdopter(Adopter adopter) {
        if (!adopters.contains(adopter)) {
            adopters.add(adopter);
        }
    }

}
