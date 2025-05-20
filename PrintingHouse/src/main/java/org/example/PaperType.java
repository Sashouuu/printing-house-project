package org.example;

//Enum for paper type
public enum PaperType {
    STANDARD, GLOSSY, NEWSPAPER;

    // Base price for each paper type(A5 size)
    public double getBasePrice(){
        switch(this){
            case STANDARD: return 0.10;
            case GLOSSY: return 0.15;
            case NEWSPAPER: return 0.05;
            default: return 0.10;
        }
    }
}
