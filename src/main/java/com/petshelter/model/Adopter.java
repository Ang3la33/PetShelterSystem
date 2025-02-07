package com.petshelter.model;

import java.util.ArrayList;
import java.util.List;

public class Adopter {

    private String name;
    private String phoneNumber;
    private List<Pet> adoptedPets;
    private List<Pet> fosteredPets;

    public Adopter(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adoptedPets = new ArrayList<>();
        this.fosteredPets = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getAdoptedPets() {
        return adoptedPets;
    }

    public List<Pet> getFosteredPets() {
        return fosteredPets;
    }

}
