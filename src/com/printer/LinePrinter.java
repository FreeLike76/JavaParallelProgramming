package com.printer;

public class LinePrinter {
    public boolean lastHorizontal = true;
    public final int MAX_PER_LINE = 100;
    public int symbolsInLine = 0;

    public void checkNewLine() {
        if (symbolsInLine == MAX_PER_LINE) {
            System.out.print("\n");
            symbolsInLine = 0;
        }
    }

    public void justPrintHorizontal() {
        checkNewLine();
        System.out.print("-");
        symbolsInLine++;
    }

    public void justPrintVertical() {
        checkNewLine();
        System.out.print("|");
        symbolsInLine++;
    }

    public synchronized void printHorizontal() throws InterruptedException {
        while (lastHorizontal) {
            wait();
        }
        checkNewLine();
        System.out.print("-");
        symbolsInLine++;
        lastHorizontal = true;
        notify();
    }

    public synchronized void printVertical() throws InterruptedException {
        while (!lastHorizontal) {
            wait();
        }
        checkNewLine();
        System.out.print("|");
        symbolsInLine++;
        lastHorizontal = false;
        notify();
    }
}
