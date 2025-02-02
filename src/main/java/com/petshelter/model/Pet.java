package com.petshelter.model;

public class Pet {

    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean isAdopted;
    private boolean isFostered;
    private boolean isOnWaitlist;

    public Pet(String name, String species, String breed, int age) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.isAdopted = false;
        this.isFostered = false;
        this.isOnWaitlist = false;
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

    public boolean isOnWaitlist() {
        return isOnWaitlist;
    }

    public void adopt() {
        if (!isAdopted() && !isFostered) {
            isAdopted = true;
            System.out.println(name + " has been adopted!");
        } else if (isFostered){
            System.out.println(name + " is currently in foster care and cannot be adopted.");
        } else {
            System.out.println(name + " is already adopted.");
        }
    }

    public void foster() {
        if (!isAdopted() && !isFostered) {
            isFostered = true;
            System.out.println(name + " is now in foster care.");
        } else if (isAdopted) {
            System.out.println(name + " has already been adopted and cannot be fostered.");
        } else {
            System.out.println(name + " is already in foster care.");
        }
    }

    public void returnFromFoster() {
        if (isFostered) {
            isFostered = false;
            System.out.println(name + " has been returned from foster care.");
        } else {
            System.out.println(name + " is not currently in foster care.");
        }
    }

    public void setOnWaitlist(boolean status) {
        this.isOnWaitlist = status;
    }



    @Override
    public String toString() {
        return name + " ( " + species + ", " + breed + ", " + age + " )" + (isAdopted ? "[Adopted]" : isFostered ? "[Fostered]" : "[Available]") +
                (isOnWaitlist ? " - Waitlisted" : "");
    }
}
