package employeemanagement;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFileHandler {

    private static final String FILE_PATH = "data/employees.dat";

    // Save employee records
    public static void saveEmployees(ArrayList<Employee> employees) {

        File folder = new File("data");
        folder.mkdirs();

        try (ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            output.writeObject(employees);
            System.out.println("Employee data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    // Load employee records
    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> loadEmployees() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                new ObjectInputStream(new FileInputStream(FILE_PATH))) {

            return (ArrayList<Employee>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
