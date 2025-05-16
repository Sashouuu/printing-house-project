package org.example.publication;

public class Publication {
    private String title;
    private int pageCount;
    private PaperSize size;
    private PaperType type;

    public Publication(String title, int pageCount, PaperSize size, PaperType type) {
        this.title = title;
        this.pageCount = pageCount;
        this.size = size;
        this.type = type;
    }

    public double calculateCost(){
        double basePrice = type.getBasePrice();
        double sizeFactor = size.getPriceFactor();
        return pageCount * basePrice * sizeFactor;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
