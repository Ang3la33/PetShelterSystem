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



}
