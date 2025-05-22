package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Printing House Management System");
    }

    // Save report data to text file
    public static void saveReportToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read report data from text file
    public static String readReportFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Serialize an employee to file
    public static void serializeEmployee(Employee employee, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize an employee from file
    public static Employee deserializeEmployee(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Employee) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
