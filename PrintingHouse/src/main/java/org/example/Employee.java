package org.example;
import java.io.*;

public abstract class Employee implements Serializable {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        if (baseSalary <= 0){
            throw new IllegalArgumentException("Base salary must be a positive number.");
        }
        this.name = name; // the name of the employee
        this.baseSalary = baseSalary; // salary
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary(double totalRevenue);

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
