# Employee Management System
## Project Documentation

### 1. Introduction
The Employee Management System is a console-based Java application developed to manage employee information. It provides basic employee management operations and maintains records using file handling.

### 2. Objectives
- To implement CRUD operations using Java.
- To understand and use ArrayList and HashMap.
- To store and retrieve employee records using file handling.
- To implement exception handling and input validation.
- To generate salary reports.

### 3. Employee Details
Each employee record contains:
- Employee ID
- Name
- Department
- Position
- Salary
- Joining Date

### 4. System Architecture

The project consists of three main Java classes:

**Employee.java**
- Defines the Employee class.
- Stores employee information.
- Provides getter and setter methods.
- Implements Serializable to support object storage.

**EmployeeManagementSystem.java**
- Contains the main application.
- Displays the menu.
- Implements add, view, search, update, and delete operations.
- Uses ArrayList and HashMap to manage employee records.
- Generates salary reports.

**EmployeeFileHandler.java**
- Saves employee records to a file.
- Loads employee records when the application starts.
- Uses ObjectOutputStream and ObjectInputStream.
- Uses try-with-resources for automatic resource management.

### 5. Java Concepts Used

| Concept | Purpose |
|---|---|
| ArrayList | Stores employee records |
| HashMap | Provides quick employee lookup using ID |
| Serialization | Converts employee objects into a storable format |
| File Handling | Saves and loads employee records |
| Exception Handling | Handles invalid input and file errors |
| CRUD Operations | Manages employee information |

### 6. Application Workflow

1. The application starts and loads saved employee records.
2. A menu is displayed to the user.
3. The user selects an operation.
4. Employee information is added, viewed, searched, updated, or deleted.
5. Changes are saved to the data file.
6. The application saves records again when the user exits.

### 7. Data Storage

Employee records are stored in:

`data/employees.dat`

Java serialization is used to write and read the ArrayList of Employee objects.

### 8. Exception Handling

The application handles:
- Invalid salary input.
- Negative salary values.
- Employee IDs that do not exist.
- File reading and writing errors.
- Missing data files.

### 9. Testing Summary

The following tests were performed:

| Test Case | Expected Result | Status |
|---|---|---|
| Add employee | Employee added successfully | Passed |
| View employees | Employee records displayed | Passed |
| Search by ID | Matching employee found | Passed |
| Search by name | Matching employee found | Passed |
| Search by department | Matching employees displayed | Passed |
| Update employee | Employee details updated | Passed |
| Invalid salary | Update cancelled safely | Passed |
| Delete employee | Employee removed | Passed |
| Salary report | Correct salary statistics displayed | Passed |
| File persistence | Records loaded after restart | Passed |
| File handling update | Application compiled and loaded saved data | Passed |

### 10. Conclusion

The Employee Management System demonstrates the practical use of Java collections, object-oriented programming, file handling, serialization, and exception handling. The project provides a simple and effective way to manage employee records while maintaining data between application sessions.