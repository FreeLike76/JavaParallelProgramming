package com.printer;

public class GridPrinterMain {
    public static void main(String[] args) {
        LinePrinter printer = new LinePrinter();

        Thread threadHorizontal = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    printer.justPrintHorizontal();
                }
            }
        });

        Thread threadVertical = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    printer.justPrintVertical();
                }

            }
        });

        threadHorizontal.start();
        threadVertical.start();
    }
}
