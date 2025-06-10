package org.example;
import java.util.*;

public class PrintingHouse {
    private List<Employee> employees = new ArrayList<>();
    private List<PaperPurchase> paperPurchases = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<PaperPurchase> getPaperPurchases() {
        return paperPurchases;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addPaperPurchase(PaperPurchase purchase) {
        paperPurchases.add(purchase);
    }

    public double calculateSalaryExpenses(double totalRevenue) {
        return employees.stream()
                .mapToDouble(e -> e.calculateSalary(totalRevenue))
                .sum();
    }

    public double calculatePaperExpenses() {
        return paperPurchases.stream()
                .mapToDouble(PaperPurchase::calculateCost)
                .sum();
    }

    @Override
    public String toString() {
        return "PrintingHouse{" +
                "employees=" + employees +
                ", paperPurchases=" + paperPurchases +
                '}';
    }
}
