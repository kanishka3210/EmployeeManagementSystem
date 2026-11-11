# Employee Management System

## Project Overview
The Employee Management System is a Java-based console application designed to manage employee records efficiently.

It allows users to add, view, search, update, and delete employee information. It also generates salary reports and stores employee records using file handling so that data remains available after restarting the application.

## Technologies Used
- Java
- ArrayList
- HashMap
- Java Serialization
- File Handling
- Exception Handling
- VS Code

## Features
- Add new employee records
- View all employees
- Search employees by ID
- Search employees by name
- Search employees by department
- Update employee details
- Delete employee records
- Generate salary reports
- Save and load employee data using file handling
- Validate salary input and handle exceptions

## Project Structure

```text
EmployeeManagementSystem/
│
├── src/
│   └── employeemanagement/
│       ├── Employee.java
│       ├── EmployeeManagementSystem.java
│       └── EmployeeFileHandler.java
│
├── data/
│   └── employees.dat
│
├── docs/
├── reports/
└── README.md
```

## How to Run the Project

### Prerequisites
- Java JDK 21 or later
- Visual Studio Code or any Java-supported IDE

### Compilation

Open the terminal in the project directory and execute:

```cmd
javac -d out src\employeemanagement\*.java
```

### Execution

```cmd
java -cp out employeemanagement.EmployeeManagementSystem
```

## Data Storage
Employee records are stored in `data/employees.dat` using Java object serialization.

The application automatically loads saved employee records when it starts and saves changes to the file.

## Salary Report
The application generates a salary report containing:
- Total number of employees
- Total salary
- Average salary
- Highest salary
- Lowest salary

## Learning Outcomes
This project demonstrates practical implementation of Java collections, object-oriented programming, file handling, serialization, and exception handling.

## Project Type
Java Developer Internship Project | Week 4: Collections & File Handling