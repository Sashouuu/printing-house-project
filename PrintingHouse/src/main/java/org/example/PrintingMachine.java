package org.example;

import java.util.*;

class PrintingMachine {
    private String id;
    private boolean supportsColor;
    private int maxPaperCapacity;
    private int speedPagesPerMinute;
    private int loadedPaper;
    private Map<Publication, Integer> printedPublications = new HashMap<>();

    public PrintingMachine(String id, boolean supportsColor, int maxPaperCapacity, int speedPagesPerMinute) {
        this.id = id;
        this.supportsColor = supportsColor;
        this.maxPaperCapacity = maxPaperCapacity;
        this.speedPagesPerMinute = speedPagesPerMinute;
        this.loadedPaper = 0;
    }

    public void loadPaper(int sheets) {
        if (loadedPaper + sheets > maxPaperCapacity) {
            loadedPaper = maxPaperCapacity;
        } else {
            loadedPaper += sheets;
        }
    }

    public void printPublication(Publication publication, PrintMode mode) throws UnsupportedPrintModeException {
        if (mode == PrintMode.COLOR && !supportsColor) {
            throw new UnsupportedPrintModeException("Machine does not support color printing.");
        }

        int totalPagesNeeded = publication.getPageCount() * publication.getQuantity();
        if (loadedPaper < totalPagesNeeded) {
            throw new RuntimeException("Not enough paper loaded in the machine.");
        }

        loadedPaper -= totalPagesNeeded;
        printedPublications.put(publication, publication.getQuantity());
    }

    public int getTotalPrintedPages() {
        return printedPublications.entrySet().stream()
                .mapToInt(e -> e.getKey().getPageCount() * e.getValue())
                .sum();
    }

    // Проверка дали има достатъчно хартия
    public boolean hasEnoughPaper(int pagesNeeded) {
        return loadedPaper >= pagesNeeded;
    }

    // Геттер за заредена хартия (по избор, за логове)
    public int getLoadedPaper() {
        return loadedPaper;
    }


    @Override
    public String toString() {
        return "PrintingMachine{" +
                "id='" + id + '\'' +
                ", supportsColor=" + supportsColor +
                ", maxPaperCapacity=" + maxPaperCapacity +
                ", speedPagesPerMinute=" + speedPagesPerMinute +
                ", loadedPaper=" + loadedPaper +
                ", printedPublications=" + printedPublications +
                '}';
    }
}
