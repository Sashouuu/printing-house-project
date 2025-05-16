package org.example.workers;

public class Manager extends Employee{
    private double bonusPercentage;
    private double revenueThreshold;

    public Manager(String name, double baseSalary, double bonusPercentage, double revenueThreshold) {
        super(name, baseSalary);
        this.bonusPercentage = bonusPercentage;
        this.revenueThreshold = revenueThreshold;
    }

    @Override
    public double calculateSalary(double totalRevenue) {
        if(totalRevenue > revenueThreshold){
            return baseSalary + (baseSalary * bonusPercentage/ 100);
        }
        return baseSalary;
    }
}
