# Employee Management System

## Overview
A simple **Employee Management System** built using **Java I/O**, providing basic CRUD operations to manage employee data including adding, updating, viewing, searching, and deleting employee records. This console-based application uses a menu-driven interface and validates user inputs.

## Features
- **Add Employee**: Create new employee records with ID, Name, Department, and Salary.
- **View All Employees**: List all the employees with their details.
- **Search Employee by ID**: Find an employee by their unique ID.
- **Update Employee**: Modify employee details (Name, Department, and Salary).
- **Delete Employee**: Remove an employee by their ID.
- **Input Validation**: The system ensures that inputs are valid and provides feedback for incorrect entries.

## Prerequisites
- **Java 8** or higher is required to run this project.
- Java IDE or command-line interface to compile and run the program.

## Installation
Follow these steps to get the project up and running:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/employee-management-system.git
2. **Navigate to the project directory:**
    ```bash
    cd employee-management-system
3. **Compile and run the application:**
    ```bash
    javac com/employeemanagementsystem/view/Main.java
    java com.employeemanagementsystem.view.Main

## Usage
Upon running the program, the following menu options will be presented:
1. Add a new employee.
2. View all employees.
3. Search for an employee by ID.
4. Update employee details.
5. Delete an employee.
6. Exit.

- **Add a new employee:** Enter employee details  including ID, Name, Department, and Salary.
- **View all employees:** Displays a list of all employees with their respective details.
- **Search for an employee:** Look up an employee using their unique ID.
- **Update an employee:** Modify an employee’s Name, Department, and Salary.
- **Delete an employee:** Remove an employee from the system by their ID.

## Future Enhancements

- **Persistent Storage:** Integrate a database (e.g., MySQL, SQLite) to persist employee data.
- **GUI Development:** Build a graphical user interface using JavaFX or Swing.
- **Unit Testing:** Add unit tests using JUnit for better code coverage.
- **Role-based Access:** Implement different access levels for administrators and employees.
- **Input Sanitization:** Improve input sanitization to prevent incorrect data entries.

