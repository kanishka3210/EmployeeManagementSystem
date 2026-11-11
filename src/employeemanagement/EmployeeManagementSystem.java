package employeemanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static HashMap<String, Employee> employeeMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        employees = EmployeeFileHandler.loadEmployees();

        for (Employee employee : employees) {
            employeeMap.put(employee.getId().trim(), employee);
        }

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by Department");
            System.out.println("8. Salary Report");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        searchEmployee();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        searchByName();
                        break;
                    case 7:
                        searchByDepartment();
                        break;
                    case 8:
                        salaryReport();
                        break;
                    case 9:
                        EmployeeFileHandler.saveEmployees(employees);
                        System.out.println("Thank you for using the system!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Please enter a valid number.");
            }

        } while (choice != 9);
    }

    // Add employee
    static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine().trim();

            if (employeeMap.containsKey(id)) {
                System.out.println("Employee ID already exists!");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Position: ");
            String position = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            if (salary < 0) {
                System.out.println("Salary cannot be negative.");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);

            System.out.print("Enter Join Date (dd-MM-yyyy): ");
            Date joinDate = sdf.parse(sc.nextLine());

            Employee employee = new Employee(
                    id, name, department, position, salary, joinDate);

            employees.add(employee);
            employeeMap.put(id, employee);

            EmployeeFileHandler.saveEmployees(employees);

            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    // View all employees
    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Search employee by ID
    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine().trim();

        Employee employee = employeeMap.get(id);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Update employee
    
static void updateEmployee() {
    System.out.print("Enter Employee ID to update: ");
    String id = sc.nextLine().trim();

    Employee employee = employeeMap.get(id);

    if (employee == null) {
        System.out.println("Employee not found.");
        return;
    }

    System.out.print("Enter new Name: ");
    String name = sc.nextLine().trim();

    System.out.print("Enter new Department: ");
    String department = sc.nextLine().trim();

    System.out.print("Enter new Position: ");
    String position = sc.nextLine().trim();

    try {
        System.out.print("Enter new Salary: ");
        double salary = Double.parseDouble(sc.nextLine().trim());

        if (salary < 0) {
            System.out.println("Salary cannot be negative. Update cancelled.");
            return;
        }

        // Update only after all inputs are valid
        employee.setName(name);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setSalary(salary);

        EmployeeFileHandler.saveEmployees(employees);
        System.out.println("Employee updated successfully!");

    } catch (NumberFormatException e) {
        System.out.println("Invalid salary. Update cancelled.");
    }
}

    // Delete employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine().trim();

        Employee employee = employeeMap.remove(id);

        if (employee != null) {
            employees.remove(employee);
            EmployeeFileHandler.saveEmployees(employees);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Search by name
    static void searchByName() {
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getName().toLowerCase()
                    .contains(name.toLowerCase())) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching employees found.");
        }
    }

    // Search by department
    static void searchByDepartment() {
        System.out.print("Enter department: ");
        String department = sc.nextLine();

        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in this department.");
        }
    }

    // Salary report
    static void salaryReport() {
        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
            return;
        }

        double totalSalary = 0;
        double highestSalary = employees.get(0).getSalary();
        double lowestSalary = employees.get(0).getSalary();

        for (Employee employee : employees) {
            double salary = employee.getSalary();

            totalSalary += salary;
            highestSalary = Math.max(highestSalary, salary);
            lowestSalary = Math.min(lowestSalary, salary);
        }

        double averageSalary = totalSalary / employees.size();

        System.out.println("\n===== SALARY REPORT =====");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Highest Salary: " + highestSalary);
        System.out.println("Lowest Salary: " + lowestSalary);
    }
}
