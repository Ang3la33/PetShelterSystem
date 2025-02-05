package com.petshelter.service;

import com.petshelter.model.Pet;
import com.petshelter.model.Adopter;
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

            int choice = getValidIntInput();

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

    private int getValidIntInput() {
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

}
