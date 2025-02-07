# Pet Shelter CLI

## Project Overview
Pet Shelter CLI is a Java-based console application designed to manage a pet shelter. It allows users to:
- **Add pets to the shelter**
- **List available pets**
- **Adopt pets**
- **Foster pets**
- **Return fostered pets**

The system follows **Object-Oriented Programming (OOP)** principles, ensuring modularity and maintainability.

## Features
- **Encapsulation & Data Integrity**: Uses private fields with controlled access through getter and setter methods.
- **Service-Based Architecture**: Separates concerns by using `PetService`, `AdopterService`,`PetShelterService` and `PetShelterConsoleService`.
- **Unit Testing**: Implements JUnit 5 tests to validate system behavior.
- **GitHub Actions CI/CD**: Automates test execution on commits and pull requests.

## Clean Code Practices
### **1. Separation of Concerns**
Each class has a specific responsibility:
- `Pet.java`: Represents a pet entity.
- `Adopter.java`: Represents an adopter.
- `PetShelter.java`: Manages shelter data.
- `PetService.java`: Handles pet state changes.
- `AdopterService.java`: Manages adoptions and fostering.
- `PetShelterService.java`: Handles shelter operations.
- `PetShelterConsoleService.java`: Handles user interactions.

### **2. Meaningful Method Names**
Methods like `findAvailablePetByNameAndSpecies()` make the code self-explanatory.

### **3. Error Handling & Validation**
- `getValidMenuInput()` ensures only valid menu options are accepted.
- `getValidSpecies()` restricts input to "CAT" or "DOG".
- `getValidYesOrNo()` restricts input to "YES" or "NO".

## Unit Testing
### **Test Coverage**
The project includes three test classes:
1. **`PetTest.java`**
   - Validates pet attributes.
   - Ensures state changes work correctly (adoption, fostering).

2. **`AdopterTest.java`**
   - Checks adopter information.
   - Tests pet adoption and fostering operations.

3. **`ShelterTest.java`**
   - Uses **Mockito** to test shelter operations.
   - Ensures adoption and fostering workflows function correctly.

