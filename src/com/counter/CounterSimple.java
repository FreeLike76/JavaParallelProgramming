package com.counter;

public class CounterSimple implements Counter {
    private int value = 0;

    public void increase() {
        this.value++;
    }

    public void decrease() {
        this.value--;
    }

    public void printValue() {
        System.out.println(value);
    }
}