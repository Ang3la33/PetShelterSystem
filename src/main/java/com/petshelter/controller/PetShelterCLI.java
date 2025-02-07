package com.petshelter.controller;

import com.petshelter.model.PetShelter;
import com.petshelter.service.PetService;
import com.petshelter.service.AdopterService;
import com.petshelter.service.PetShelterService;
import com.petshelter.service.PetShelterConsoleService;

public class PetShelterCLI {

    public static void main(String[] args) {

        PetShelter petShelter = new PetShelter("Angie's Angels");
        PetService petService = new PetService();
        AdopterService adopterService = new AdopterService(petService);
        PetShelterService petShelterService = new PetShelterService(petShelter,petService,adopterService);

        PetShelterConsoleService consoleService = new PetShelterConsoleService(petShelter,petShelterService);
        consoleService.displayMenu();
    }
}
