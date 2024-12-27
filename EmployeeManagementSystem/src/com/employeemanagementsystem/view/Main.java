/**
 * Main class for the Employee Management System.
 * 
 * <p>This class serves as the view component of the application, implementing 
 * the user interface for managing employees. It interacts with the 
 * {@link EmployeeManager} class from the controller layer to perform CRUD 
 * operations on employee data.</p>
 *
 * <h2>Features:</h2>
 * <ul>
 *     <li>Adding a new employee</li>
 *     <li>Viewing all employees</li>
 *     <li>Searching for an employee by ID</li>
 *     <li>Updating employee details</li>
 *     <li>Deleting an employee</li>
 *     <li>Exiting the system</li>
 * </ul>
 */
package com.employeemanagementsystem.view;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.controller.EmployeeManager;

import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * The entry point of the Employee Management System application.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EmployeeManager employeeManager = new EmployeeManager();
            while (true) {
                displayMenu();
                int choice = getInput(scanner, "Enter your choice: ", false);
                switch (choice) {
                    case 1 -> addEmployee(scanner, employeeManager);
                    case 2 -> viewAllEmployees(employeeManager);
                    case 3 -> searchEmployeeByID(scanner, employeeManager);
                    case 4 -> updateEmployeeByID(scanner, employeeManager);
                    case 5 -> deleteEmployeeByID(scanner, employeeManager);
                    case 6 -> {
                        if (confirmExit(scanner)) return;
                    }
                    default -> System.out.println("Invalid option! Please try again.");
                }
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("================================");
        System.out.println("Employee Management System");
        System.out.println("1. Add a new employee.");
        System.out.println("2. View all employees.");
        System.out.println("3. Search for an employee by ID.");
        System.out.println("4. Update employee details.");
        System.out.println("5. Delete an employee.");
        System.out.println("6. Exit.");
        System.out.println("================================");
    }

    /**
     * Prompts the user for input and ensures valid integer input.
     *
     * @param scanner   Scanner object for reading user input.
     * @param prompt    The message to display to the user.
     * @param allowText Whether to allow text input instead of integers.
     * @return The integer input or -1 if text input is allowed and provided.
     */
    private static int getInput(Scanner scanner, String prompt, boolean allowText) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            if (allowText && scanner.hasNextLine()) return -1;
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Handles the logic for adding a new employee.
     *
     * @param scanner         Scanner object for reading user input.
     * @param employeeManager The controller for managing employees.
     */
    private static void addEmployee(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        if (employeeManager.addEmployee(id, name, department, salary)) {
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Failed to add employee. Employee ID may already exist.");
        }
    }

    /**
     * Displays all employees managed by the system.
     *
     * @param employeeManager The controller for managing employees.
     */
    private static void viewAllEmployees(EmployeeManager employeeManager) {
        List<Employee> employees = employeeManager.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employees) {
                displayEmployee(emp);
            }
        }
    }

    /**
     * Searches for an employee by their ID.
     *
     * @param scanner         Scanner object for reading user input.
     * @param employeeManager The controller for managing employees.
     */
    private static void searchEmployeeByID(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee employee = employeeManager.searchEmployeeByID(id);
        if (employee != null) {
            displayEmployee(employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    /**
     * Updates the details of an existing employee by their ID.
     *
     * @param scanner         Scanner object for reading user input.
     * @param employeeManager The controller for managing employees.
     */
    private static void updateEmployeeByID(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Department: ");
        String newDepartment = scanner.nextLine();
        System.out.print("Enter New Salary: ");
        double newSalary = scanner.nextDouble();

        if (employeeManager.updateEmployeeByID(id, newName, newDepartment, newSalary)) {
            System.out.println("Employee details updated successfully!");
        } else {
            System.out.println("Failed to update employee. Please check the ID and try again.");
        }
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param scanner         Scanner object for reading user input.
     * @param employeeManager The controller for managing employees.
     */
    private static void deleteEmployeeByID(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        if (employeeManager.deleteEmployeeByID(id)) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Failed to delete employee. Please check the ID and try again.");
        }
    }

    /**
     * Confirms if the user wants to exit the application.
     *
     * @param scanner Scanner object for reading user input.
     * @return True if the user confirms, otherwise false.
     */
    private static boolean confirmExit(Scanner scanner) {
        System.out.print("Are you sure you want to exit? (yes/no): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    /**
     * Displays the details of a single employee.
     *
     * @param emp The employee object whose details are to be displayed.
     */
    private static void displayEmployee(Employee emp) {
        System.out.println("----------------------------");
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Salary: " + emp.getSalary());
    }
}
