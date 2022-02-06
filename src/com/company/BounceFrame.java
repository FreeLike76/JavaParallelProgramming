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
        JButton buttonStartL100 = new JButton("Start Min 100");
        JButton buttonStartH = new JButton("Start Max");
        JButton buttonStartH100 = new JButton("Start Max 100");
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

        buttonStartL100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 100; i++) {
                    Ball b = new Ball(canvas, Color.yellow);
                    canvas.add(b);
                    BallThread thread = new BallThread(b);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }
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

        buttonStartH100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 100; i++) {
                    Ball b = new Ball(canvas, Color.blue);
                    canvas.add(b);
                    BallThread thread = new BallThread(b);
                    thread.setPriority(Thread.MAX_PRIORITY);
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
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
        bottomPanel.add(buttonStartL100);
        bottomPanel.add(buttonStartH);
        bottomPanel.add(buttonStartH100);
        bottomPanel.add(buttonStop);

        content.add(bottomPanel, BorderLayout.SOUTH);
    }
}
