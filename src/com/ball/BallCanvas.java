package com.ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    public BallCanvasHole hole = new BallCanvasHole(64, 64);
    private JLabel counter = null;

    public int fell = 0;

    public void add(Ball b) {
        this.balls.add(b);
    }

    public void setCounterLabel(JLabel label){
        this.counter = label;
    }

    public void clearFallen() {
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).fell) {
                balls.remove(i);
                fell += 1;
                i--;
            }
        }
        if(counter != null){
            counter.setText(Integer.toString(fell));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        hole.draw(g2);
        // remove fallen
        clearFallen();

        // draw
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
    }
}
