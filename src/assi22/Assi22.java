/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assi22;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Assi22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LoadEntry> loadEntries = new ArrayList<>();

        boolean exit = false; // Flag to control program exit

        while (!exit) { // Run continuously until exit is set to true
            System.out.println("----------------------------------------");
            System.out.println("Load System Application");
            System.out.println("Enter (1) to launch menu or any other key to exit.");
            System.out.println("----------------------------------------");

            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                displayMainMenu();
                String subMenuChoice = scanner.nextLine();

                switch (subMenuChoice) {
                    case "1":
                        captureNewLoad(scanner, loadEntries);
                        break;
                    case "2":
                        searchForLoad(scanner, loadEntries);
                        break;
                    case "3":
                        deleteLoad(scanner, loadEntries);
                        break;
                    case "4":
                        printLoadReport(loadEntries);
                        break;
                    case "5":
                        exit = true;
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                        break;
                }
            } else {
                exit = true;
                System.out.println("Exiting the application.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new Load.");
        System.out.println("(2) Search for a Load.");
        System.out.println("(3) Delete a Load.");
        System.out.println("(4) Print Load report.");
        System.out.println("(5) Exit application.");
        System.out.println("----------------------------------------");
    }

    static void captureNewLoad(Scanner scanner, ArrayList<LoadEntry> loadEntries) {
        System.out.println("Capture a new Load.");
        System.out.print("Enter the trip number: ");
        String tripNumber = scanner.nextLine();

        System.out.print("Enter the driver's name: ");
        String driverName = scanner.nextLine();

        System.out.print("Enter the product: ");
        String product = scanner.nextLine();

        double quantity;
        do {
            System.out.print("Enter the quantity (ton): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Quantity must be a number.");
                System.out.print("Enter the quantity (ton): ");
                scanner.next();  // Consume the non-double input
            }
            quantity = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character
        } while (quantity <= 0);

        System.out.print("Enter the fuel level (full, three quarters, half, quarter): ");
        String fuelLevel = scanner.nextLine();

        LoadEntry newLoad = new LoadEntry(tripNumber, driverName, product, quantity, fuelLevel);
        loadEntries.add(newLoad);

        System.out.println("Load details have been successfully saved.");
    }

    static void searchForLoad(Scanner scanner, ArrayList<LoadEntry> loadEntries) {
        System.out.println("Search for a Load.");
        System.out.print("Enter the trip number to search for: ");
        String searchTripNumber = scanner.nextLine();

        boolean loadFound = false;
        for (LoadEntry load : loadEntries) {
            if (load.getTripNumber().equalsIgnoreCase(searchTripNumber)) {
                // Load found, display its details
                System.out.println("Load details found:");
                System.out.println("Trip Number: " + load.getTripNumber());
                System.out.println("Driver's Name: " + load.getDriverName());
                System.out.println("Product: " + load.getProduct());
                System.out.println("Quantity (ton): " + load.getQuantity());
                System.out.println("Fuel Level: " + load.getFuelLevel());
                loadFound = true;
                break;
            }
        }

        if (!loadFound) {
            System.out.println("Load with trip number " + searchTripNumber + " not found.");
        }
    }

    static void deleteLoad(Scanner scanner, ArrayList<LoadEntry> loadEntries) {
        System.out.println("Delete a Load.");
        System.out.print("Enter the trip number to delete: ");
        String deleteTripNumber = scanner.nextLine();

        boolean loadFound = false;
        for (LoadEntry load : loadEntries) {
            if (load.getTripNumber().equalsIgnoreCase(deleteTripNumber)) {
                // Load found, ask for confirmation
                System.out.println("Load details found:");
                System.out.println("Trip Number: " + load.getTripNumber());
                System.out.println("Driver's Name: " + load.getDriverName());
                System.out.println("Product: " + load.getProduct());
                System.out.println("Quantity (ton): " + load.getQuantity());
                System.out.println("Fuel Level: " + load.getFuelLevel());

                System.out.print("Do you want to delete this load? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    // Delete the load if confirmed
                    loadEntries.remove(load);
                    System.out.println("Load deleted successfully.");
                } else {
                    System.out.println("Load not deleted.");
                }

                loadFound = true;
                break;
            }
        }

        if (!loadFound) {
            System.out.println("Load with trip number " + deleteTripNumber + " not found.");
        }
    }

    static void printLoadReport(ArrayList<LoadEntry> loadEntries) {
        System.out.println("Print Load report.");
        if (loadEntries.isEmpty()) {
            System.out.println("No load entries to report.");
        } else {
            System.out.println("Load Report:");
            for (LoadEntry load : loadEntries) {
                System.out.println("Trip Number: " + load.getTripNumber());
                System.out.println("Driver's Name: " + load.getDriverName());
                System.out.println("Product: " + load.getProduct());
                System.out.println("Quantity (ton): " + load.getQuantity());
                System.out.println("Fuel Level: " + load.getFuelLevel());
                System.out.println("----------------------------------------");
            }
        }
    }
}


  
