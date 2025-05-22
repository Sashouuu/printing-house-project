package org.example;
import java.io.*;

public abstract class Employee implements Serializable {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary(double totalRevenue);
}
