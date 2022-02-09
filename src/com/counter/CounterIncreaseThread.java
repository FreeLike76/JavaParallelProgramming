package com.counter;

public class CounterIncreaseThread extends Thread {
    private Counter counter;

    public CounterIncreaseThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            this.counter.increase();
        }
    }
}
