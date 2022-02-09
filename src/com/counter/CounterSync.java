package com.counter;

public class CounterSync implements Counter {
    private int value = 0;

    public synchronized void increase() {
        this.value++;
    }

    public synchronized void decrease() {
        this.value--;
    }

    public void printValue() {
        System.out.println(value);
    }
}
