package com.petshelter.service;

import com.petshelter.model.Pet;
import com.petshelter.model.PetShelter;

import java.util.Scanner;

public class PetShelterConsoleService {

    private Scanner scanner;
    private PetShelter petShelter;
    private PetShelterService petShelterService;

    public PetShelterConsoleService(PetShelter petShelter, PetShelterService petShelterService) {
        this.scanner = new Scanner(System.in);
        this.petShelter = petShelter;
        this.petShelterService = petShelterService;
    }

    public void displayMenu() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to " + petShelter.getName() + "!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add a Pet");
            System.out.println("2. List Available Pets");
            System.out.println("3. Adopt a Pet");
            System.out.println("4. Foster a Pet");
            System.out.println("5. Return a Foster Pet");
            System.out.println("6. Exit");
            System.out.println("Please select an option: ");

            int choice = getValidMenuInput();

            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    listAvailablePets();
                    break;
                case 3:
                    adoptPet();
                    break;
                case 4:
                    fosterPet();
                    break;
                case 5:
                    returnFosterPet();
                    break;
                case 6:
                    System.out.println("Thank you for visiting " + petShelter.getName() + "!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice: Please select a number between 1 and 6.");
            }
        }
    }

    private int getValidMenuInput() {
        int input;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid Input: Please enter a number.");
                scanner.next();
            } else {
                input = scanner.nextInt();
                scanner.nextLine();

                if (input >= 1 && input <= 6) {
                    return input;
                } else {
                    System.out.println("Invalid choice: Please enter a number between 1 and 6.");
                }
            }
            System.out.println("Select an option: ");
        }
    }

    private Pet findPetByNameAndSpecies(String name, String species) {
        return petShelter.getAvailablePets().stream()
                .filter(pet -> pet.getName().equalsIgnoreCase(name) && pet.getSpecies().equalsIgnoreCase(species))
                .findFirst()
                .orElse(null);
    }

    private int getValidIntInput() {
        int input;
        while(true) {
            if(!scanner.hasNextInt()) {
                System.out.println("Invalid input: Please enter a valid number");
                scanner.next();
            } else {
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            }
            System.out.println("Enter pet's age: ");
        }
    }

    private void addPet() {
        System.out.println("Enter pet's name: ");
        String name = scanner.nextLine().trim().toUpperCase();

        String species;
        while (true) {
            System.out.println("Enter the pet's species: ");
            species = scanner.nextLine().trim().toUpperCase();
            if (species.equals("CAT") || species.equals("DOG")) {
                break;
            }
            System.out.println("Sorry, this shelter can only take a cat or a dog.");
        }

        if (findPetByNameAndSpecies(name, species) != null) {
            System.out.println("A " + species.toLowerCase() + " with this name is already at the shelter");
            System.out.println("Please add a last name and try again.");
            return;
        }

        System.out.println("Enter breed: ");
        String breed = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter age: ");
        int age = getValidIntInput();

        Pet pet = new Pet(name, species, breed, age);
        petShelterService.addPet(pet);
        System.out.println(pet.getName() + " the " + species + " has been added to " + petShelter.getName() + "!" );
    }

}
