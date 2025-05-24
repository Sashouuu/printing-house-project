package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrintingHouseTests {

    @Test
    public void testMachineOperatorSalary() {
        Employee operator = new MachineOperator("Ivan", 1000);
        assertEquals(1000, operator.calculateSalary(5000));
    }

    @Test
    public void testManagerSalaryWithoutBonus() {
        Employee manager = new Manager("Maria", 2000, 10, 10000);
        assertEquals(2000, manager.calculateSalary(9000));
    }

    @Test
    public void testManagerSalaryWithBonus() {
        Employee manager = new Manager("Maria", 2000, 10, 10000);
        assertEquals(2200, manager.calculateSalary(11000));
    }

    @Test
    public void testPaperPurchaseCost() {
        PaperPurchase purchase = new PaperPurchase(PaperType.GLOSSY, PaperSize.A4, 100);
        assertEquals(100 * 0.15 * 1.2, purchase.calculateCost());
    }

    @Test
    public void testPublicationCostPerUnit() {
        Publication pub = new Publication("Book", 50, PaperSize.A3, PaperType.STANDARD, 10, 100, 5);
        double expected = 50 * 0.10 * 1.5;
        assertEquals(expected, pub.calculateCostPerUnit());
    }

    @Test
    public void testPublicationRevenueWithoutDiscount() {
        Publication pub = new Publication("Magazine", 30, PaperSize.A5, PaperType.NEWSPAPER, 50, 100, 10);
        double unitPrice = pub.calculateCostPerUnit();
        assertEquals(50 * unitPrice, pub.calculateRevenue());
    }

    @Test
    public void testPublicationRevenueWithDiscount() {
        Publication pub = new Publication("Poster", 10, PaperSize.A2, PaperType.GLOSSY, 150, 100, 20);
        double unitPrice = 10 * 0.15 * 1.8 * 0.8; // 20% discount
        assertEquals(150 * unitPrice, pub.calculateRevenue(), 0.01);
    }

    @Test
    public void testPrintingMachineLoadPaper() {
        PrintingMachine machine = new PrintingMachine("M1", true, 500, 100);
        machine.loadPaper(600);
        assertDoesNotThrow(() -> {}); // no exception expected
    }

    @Test
    public void testPrintingMachinePrintSupported() {
        PrintingMachine machine = new PrintingMachine("M2", true, 1000, 100);
        Publication pub = new Publication("Report", 5, PaperSize.A4, PaperType.STANDARD, 100, 200, 10);
        machine.loadPaper(1000);
        assertDoesNotThrow(() -> machine.printPublication(pub, PrintMode.COLOR));
    }

    @Test
    public void testPrintingMachinePrintUnsupportedColor() {
        PrintingMachine machine = new PrintingMachine("M3", false, 1000, 100);
        Publication pub = new Publication("Invoice", 2, PaperSize.A5, PaperType.STANDARD, 100, 200, 5);
        machine.loadPaper(500);
        assertThrows(UnsupportedPrintModeException.class, () -> machine.printPublication(pub, PrintMode.COLOR));
    }

    @Test
    public void testPrintingMachineTotalPrintedPages() {
        PrintingMachine machine = new PrintingMachine("M4", true, 1000, 100);
        Publication pub = new Publication("Flyer", 2, PaperSize.A4, PaperType.GLOSSY, 100, 200, 10);
        machine.loadPaper(1000);
        try {
            machine.printPublication(pub, PrintMode.COLOR);
        } catch (UnsupportedPrintModeException e) {
            fail("Should support color printing");
        }
        assertEquals(200, machine.getTotalPrintedPages());
    }

    @Test
    public void testPrintingHouseExpenses() {
        PrintingHouse house = new PrintingHouse();
        house.addEmployee(new MachineOperator("Ivan", 1000));
        house.addEmployee(new Manager("Maria", 2000, 10, 5000));
        house.addPaperPurchase(new PaperPurchase(PaperType.STANDARD, PaperSize.A4, 100));

        double salaryExpenses = house.calculateSalaryExpenses(6000); // triggers manager bonus
        double paperExpenses = 100 * 0.10 * 1.2;

        assertEquals(1000 + 2200, salaryExpenses);
        assertEquals(paperExpenses, house.calculatePaperExpenses());
    }
}
