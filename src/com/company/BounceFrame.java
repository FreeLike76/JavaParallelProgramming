package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.lightGray);

        JLabel fellCounter = new JLabel("0");
        canvas.setCounterLabel(fellCounter);
        bottomPanel.add(fellCounter);

        JButton buttonStartL = new JButton("Start Min");
        JButton buttonStartH = new JButton("Start Max");
        JButton buttonStartCompare = new JButton("Start Compare");
        JButton buttonStop = new JButton("Stop");

        buttonStartL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b = new Ball(canvas, Color.yellow);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.setPriority(Thread.MIN_PRIORITY);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });

        buttonStartH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b = new Ball(canvas, Color.blue);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.setPriority(Thread.MAX_PRIORITY);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });

        buttonStartCompare.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ball bMax = new Ball(canvas, Color.blue,
                        (int) (canvas.getWidth() * 0.6),
                        (int) (canvas.getHeight() * 0.6),
                        2, 2);

                canvas.add(bMax);
                BallThread threadMax = new BallThread(bMax);
                threadMax.setPriority(Thread.MAX_PRIORITY);
                threadMax.start();
                System.out.println("Thread name = " + threadMax.getName()
                        + ", Priority = " + threadMax.getPriority());

                for (int i = 0; i < 5; i++) {
                    Ball bMin = new Ball(canvas, Color.yellow,
                            (int) (canvas.getWidth() * 0.6),
                            (int) (canvas.getHeight() * 0.6),
                            2, 2);
                    canvas.add(bMin);
                    BallThread threadMin = new BallThread(bMin);
                    threadMin.setPriority(Thread.MIN_PRIORITY);
                    threadMin.start();
                    System.out.println("Thread name = " + threadMin.getName()
                            + ", Priority = " + threadMin.getPriority());
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        bottomPanel.add(buttonStartL);
        bottomPanel.add(buttonStartH);
        bottomPanel.add(buttonStartCompare);
        bottomPanel.add(buttonStop);

        content.add(bottomPanel, BorderLayout.SOUTH);
    }
}
