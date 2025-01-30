package com.petshelter;

public class Pet {

    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean isAdopted;

    public Pet(String name, String species, String breed, int age) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.isAdopted = false;
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

    public void adopt() {
        if (!isAdopted) {
            isAdopted = true;
            System.out.println(name + " has been adopted!");
        } else {
            System.out.println(name + " is already adopted.");
        }
    }

    @Override
    public String toString() {
        return name + " ( " + species + ", " + breed + ", " + age + " )" + (isAdopted ? "[Adopted]" : "[Available]");
    }
}
