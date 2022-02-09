package com.counter;

public class CounterSyncObject implements Counter {
    private int value = 0;
    private Object sync = new Object();

    public void increase() {
        synchronized (sync) {
            this.value++;
        }
    }

    public void decrease() {
        synchronized (sync) {
            this.value--;
        }
    }

    public void printValue() {
        System.out.println(value);
    }
}
