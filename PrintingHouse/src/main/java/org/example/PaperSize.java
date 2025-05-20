package org.example;

// Enumeration for paper size
public enum PaperSize {
    A5, A4, A3, A2, A1;

    //Method to calculate price
    public double getPriceFactor(){
        switch(this){
            case A5: return 1.0;
            case A4: return 1.2;
            case A3: return 1.5;
            case A2: return 1.8;
            case A1: return 2.0;
            default: return 1.0;
        }
    }
}
