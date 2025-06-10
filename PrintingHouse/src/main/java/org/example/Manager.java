package org.example;

public class Manager extends Employee {
    private double bonusPercentage;
    private double revenueThreshold;
    private double currentRevenue;

    public Manager(String name, double baseSalary, double bonusPercentage, double revenueThreshold) {
        super(name, baseSalary);
        if (bonusPercentage < 0 || revenueThreshold < 0) {
            throw new IllegalArgumentException("Bonus percentage and revenue threshold must be non-negative.");
        }
        this.bonusPercentage = bonusPercentage;
        this.revenueThreshold = revenueThreshold;

    }

    @Override
    public double calculateSalary(double totalRevenue) {
        if (totalRevenue > revenueThreshold) {
            return baseSalary + (baseSalary * bonusPercentage / 100);
        } else {
            return baseSalary;
        }
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public double getRevenueThreshold() {
        return revenueThreshold;
    }

    @Override
    public String toString() {
        return "Manager{name='" + name + "', baseSalary=" + baseSalary +
                ", bonusPercentage=" + bonusPercentage +
                ", revenueThreshold=" + revenueThreshold + "}";
    }

}