package com.petshelter;

import java.util.ArrayList;
import java.util.List;

public class Adopter {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Pet> adoptedPets;
    private List<Pet> fosteredPets;

    public Adopter(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.adoptedPets = new ArrayList<>();
        this.fosteredPets = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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

//    public void adoptPet(Pet pet) {
//        if (!pet.isAdopted()) {
//            pet.adopt();
//            adoptedPets.add(pet);
//            System.out.println(name + " has adopted");
//        }
//    }

}
