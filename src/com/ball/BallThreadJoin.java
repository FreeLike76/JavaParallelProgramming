package com.ball;

public class BallThreadJoin extends Thread {
    private Ball ball;
    private BallThread otherThread;

    public BallThreadJoin(Ball ball, BallThread otherThread) {
        this.ball = ball;
        this.otherThread = otherThread;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread name = "
                    + Thread.currentThread().getName()
                    + ", waiting for other thread.");
            otherThread.join();
            System.out.println("Thread name = "
                    + Thread.currentThread().getName()
                    + ", join complete.");
            for (int i = 1; i < 10000; i++) {
                if (!ball.move()) {
                    break;
                }
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            System.out.println("Thread name = "
                    + Thread.currentThread().getName()
                    + ", InterruptedException!");
        }
        System.out.println("Thread is closing, name = "
                + Thread.currentThread().getName());
    }
}
