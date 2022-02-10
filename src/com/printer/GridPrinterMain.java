package com.printer;

public class GridPrinterMain {

    public static void main(String[] args) {
        LinePrinter printer = new LinePrinter();

        Thread threadHorizontal = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        printer.printHorizontal();
                    }
                } catch (InterruptedException e) {

                }

            }
        });

        Thread threadVertical = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        printer.printVertical();
                    }
                } catch (InterruptedException e) {

                }
            }
        });

        threadHorizontal.start();
        threadVertical.start();
    }

}
