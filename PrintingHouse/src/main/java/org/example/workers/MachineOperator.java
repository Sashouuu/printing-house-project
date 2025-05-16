package org.example.workers;

public class MachineOperator extends Employee {
    public MachineOperator(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary(double totalRevenue) {
        return baseSalary;
    }
}
