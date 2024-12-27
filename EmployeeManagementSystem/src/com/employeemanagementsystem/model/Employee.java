package com.employeemanagementsystem.model;

/**
 * Represents an Employee in the Employee Management System.
 * This class acts as the model in the MVC architecture, encapsulating
 * the details of an employee, including their ID, name, department, and salary.
 * 
 * <p>Author: Abdul Rafay</p>
 * <p>Version: Java 22</p>
 */
public class Employee {

    private int id; // Unique identifier for the employee
    private String name; // Name of the employee
    private String department; // Department where the employee works
    private double salary; // Salary of the employee

    /**
     * Gets the employee ID.
     * 
     * @return the unique ID of the employee.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the employee ID.
     * 
     * @param id the unique ID to set for the employee.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the employee.
     * 
     * @return the name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     * 
     * @param name the name to set for the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the department of the employee.
     * 
     * @return the department where the employee works.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the employee.
     * 
     * @param department the department to set for the employee.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the salary of the employee.
     * 
     * @return the salary of the employee.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     * 
     * @param salary the salary to set for the employee.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Provides a string representation of the Employee object.
     * 
     * @return a string containing the employee's details.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
