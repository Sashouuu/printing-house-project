package org.example;

class Publication {
    private String title;
    private int pageCount;
    private PaperSize size;
    private PaperType type;
    private int quantity;
    private int discountThreshold;
    private double discountPercent;

    public Publication(String title, int pageCount, PaperSize size, PaperType type,
                       int quantity, int discountThreshold, double discountPercent) {
        this.title = title;
        this.pageCount = pageCount;
        this.size = size;
        this.type = type;
        this.quantity = quantity;
        this.discountThreshold = discountThreshold;
        this.discountPercent = discountPercent;
    }

    // GETTERS AND SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public PaperSize getSize() {
        return size;
    }

    public void setSize(PaperSize size) {
        this.size = size;
    }

    public PaperType getType() {
        return type;
    }

    public void setType(PaperType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscountThreshold() {
        return discountThreshold;
    }

    public void setDiscountThreshold(int discountThreshold) {
        this.discountThreshold = discountThreshold;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    //END OF GETTERS AND SETTERS


    public double calculateCostPerUnit() {
        double basePrice = type.getBasePrice();
        double sizeFactor = size.getPriceFactor();
        return pageCount * basePrice * sizeFactor;
    }

    public double calculateRevenue() {
        double unitPrice = calculateCostPerUnit();
        if (quantity > discountThreshold) {
            unitPrice *= (1 - discountPercent / 100);
        }
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "Publication: " + title + " | Pages: " + pageCount + " | Size: " + size + " | Type: " + type +
                " | Quantity: " + quantity + " | Unit Price: " + calculateCostPerUnit() + " | Revenue: " + calculateRevenue();
    }
}
