package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Printing House Management System");
        System.out.println("Welcome to the Printing House Management System");

        // Създаване на печатница
        PrintingHouse house = new PrintingHouse();

        // Добавяне на служители
        Employee operator = new MachineOperator("Ivan", 1000);
        Employee manager = new Manager("Maria", 2000, 10, 5000);
        house.addEmployee(operator);
        house.addEmployee(manager);

        // Сериализация на служител
        serializeEmployee(manager, "manager.ser");
        Employee deserializedManager = deserializeEmployee("manager.ser");
        System.out.println("Deserialized manager: " + (deserializedManager != null ? deserializedManager.getClass().getSimpleName() : "null"));

        // Покупка на хартия
        PaperPurchase purchase = new PaperPurchase(PaperType.GLOSSY, PaperSize.A4, 300);
        house.addPaperPurchase(purchase);

        // Създаване на публикация
        Publication book = new Publication("Java Guide", 100, PaperSize.A4, PaperType.GLOSSY, 200, 150, 10);

        // Създаване на машина и печат
        PrintingMachine machine = new PrintingMachine("PM1", true, 25000, 50);
        machine.loadPaper(20001);

        int pagesNeeded = book.getPageCount() * book.getQuantity();
        System.out.println("Needed sheets " + pagesNeeded);
        System.out.println("Sheets in machine: " + machine.getLoadedPaper());

        if (machine.hasEnoughPaper(pagesNeeded)) {
            try {
                machine.printPublication(book, PrintMode.COLOR);
            } catch (UnsupportedPrintModeException e) {
                System.out.println("Print error: " + e.getMessage());
            }
        } else {
            System.out.println("Insufficient paper. Please add more.");
        }


        // Приходи и разходи
        double revenue = book.calculateRevenue();
        double salaries = house.calculateSalaryExpenses(revenue);
        double paperCosts = house.calculatePaperExpenses();

        // Генериране на отчет
        String report = "Revenue: " + revenue +
                "\nSalaries: " + salaries +
                "\nPaper Costs: " + paperCosts +
                "\nTotal Expenses: " + (salaries + paperCosts) +
                "\nProfit: " + (revenue - salaries - paperCosts);
        saveReportToFile("report.txt", report);

        String loaded = readReportFromFile("report.txt");
        System.out.println("\nRead from file:\n" + loaded);

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
