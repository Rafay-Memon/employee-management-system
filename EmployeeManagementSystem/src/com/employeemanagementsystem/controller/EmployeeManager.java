package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the business logic and operations related to Employee management.
 * This class acts as the controller in the MVC architecture, providing functionalities
 * such as adding, searching, updating, deleting, and retrieving employee records.
 * 
 * <p>Data is persisted in a text file located at {@code src/file/employee.txt}.</p>
 * 
 * <p>Author: Abdul Rafay</p>
 * <p>Version: Java 22</p>
 */
public class EmployeeManager {

    private final static String FILE_PATH = "src/file/employee.txt"; // Path to the employee data file

    /**
     * Adds a new employee to the system.
     * 
     * @param id          the unique ID of the employee.
     * @param name        the name of the employee.
     * @param department  the department where the employee works.
     * @param salary      the salary of the employee.
     * @return {@code true} if the employee was successfully added, {@code false} otherwise.
     */
    public boolean addEmployee(int id, String name, String department, double salary) {
        try {
            List<Employee> employees = getAllEmployees();

            // Check if the ID already exists
            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    System.out.println("Employee with ID " + id + " already exists.");
                    return false;
                }
            }

            // Create and add the new employee
            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setDepartment(department);
            emp.setSalary(salary);

            employees.add(emp);

            // Persist the updated list
            writeAllEmployees(employees);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Searches for an employee by their unique ID.
     * 
     * @param id the ID of the employee to search for.
     * @return the {@link Employee} object if found, or {@code null} if not found.
     */
    public Employee searchEmployeeByID(int id) {
        List<Employee> employees = getAllEmployees();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    /**
     * Deletes an employee by their unique ID.
     * 
     * @param id the ID of the employee to delete.
     * @return {@code true} if the employee was successfully deleted, {@code false} otherwise.
     */
    public boolean deleteEmployeeByID(int id) {
        List<Employee> employees = getAllEmployees();
        boolean isDeleted = employees.removeIf(emp -> emp.getId() == id);

        if (isDeleted) {
            writeAllEmployees(employees);
        }

        return isDeleted;
    }

    /**
     * Updates the details of an employee by their unique ID.
     * 
     * @param id           the ID of the employee to update.
     * @param newName      the new name of the employee.
     * @param newDepartment the new department of the employee.
     * @param newSalary    the new salary of the employee.
     * @return {@code true} if the employee was successfully updated, {@code false} otherwise.
     */
    public boolean updateEmployeeByID(int id, String newName, String newDepartment, double newSalary) {
        List<Employee> employees = getAllEmployees();
        boolean isUpdated = false;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setDepartment(newDepartment);
                emp.setSalary(newSalary);
                isUpdated = true;
                break;
            }
        }

        if (isUpdated) {
            writeAllEmployees(employees);
        }

        return isUpdated;
    }

    /**
     * Retrieves all employees from the data file.
     * 
     * @return a list of {@link Employee} objects representing all employees in the system.
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            Employee emp = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID: ")) {
                    emp = new Employee();
                    emp.setId(Integer.parseInt(line.substring(4)));
                } else if (line.startsWith("Name: ")) {
                    emp.setName(line.substring(6));
                } else if (line.startsWith("Department: ")) {
                    emp.setDepartment(line.substring(12));
                } else if (line.startsWith("Salary: ")) {
                    emp.setSalary(Double.parseDouble(line.substring(8)));
                    employees.add(emp); // Add employee when salary line is reached
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    /**
     * Writes the list of employees to the data file in a human-readable format.
     * 
     * @param employees the list of {@link Employee} objects to write to the file.
     */
    public void writeAllEmployees(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Employee emp : employees) {
                writer.write("ID: " + emp.getId() + "\n");
                writer.write("Name: " + emp.getName() + "\n");
                writer.write("Department: " + emp.getDepartment() + "\n");
                writer.write("Salary: " + emp.getSalary() + "\n");
                writer.write("----------------------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
