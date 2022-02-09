package com.counter;

public class CounterDecreaseThread extends Thread {

    private Counter counter;

    public CounterDecreaseThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            this.counter.decrease();
        }
    }
}
