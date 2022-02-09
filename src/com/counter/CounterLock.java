package com.counter;

import java.util.concurrent.locks.ReentrantLock;

public class CounterLock implements Counter {
    public int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void increase() {
        lock.lock();
        try {
            this.value++;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void decrease() {
        lock.lock();
        try {
            this.value--;
        } finally {
            lock.unlock();
        }
    }

    public void printValue() {
        System.out.println(value);
    }
}
