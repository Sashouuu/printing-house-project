package org.example;

public class PaperPurchase {
    private PaperType type;
    private PaperSize size;
    private int quantity;

    public PaperPurchase(PaperType type, PaperSize size, int quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }

    public double calculateCost() {
        double basePrice = type.getBasePrice();
        double sizeFactor = size.getPriceFactor();
        return quantity * basePrice * sizeFactor;
    }
}
