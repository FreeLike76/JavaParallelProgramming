package com.counter;

public class CounterMain {
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            Counter counter = new CounterSimple();
            //Counter counter = new CounterSync ();
            //Counter counter = new CounterSyncObject ();
            //Counter counter = new CounterLock ();

            Thread first = new CounterIncreaseThread(counter);
            Thread second = new CounterDecreaseThread(counter);
            first.start();
            second.start();
            try {
                first.join();
                second.join();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            counter.printValue();
        }
    }
}
