package com.petshelter.model;

public class Pet {

    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean isAdopted;
    private boolean isFostered;

    public Pet(String name, String species, String breed, int age) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.isAdopted = false;
        this.isFostered = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public boolean isFostered() {
        return isFostered;
    }

    public void setAdopted(boolean adopted) {
        this.isAdopted = adopted;
    }

    public void setFostered(boolean fostered) {
        this.isFostered = fostered;
    }

    @Override
    public String toString() {
        return name + " ( " + species + ", " + breed + ", " + age + " )" + (isAdopted ? "[Adopted]" : isFostered ? "[Fostered]" : "[Available]") +
                (isOnWaitlist ? " - Waitlisted" : "");
    }
}
