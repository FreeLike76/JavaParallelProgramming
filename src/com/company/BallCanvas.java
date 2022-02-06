package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();

    public final int holeWidth = 32;
    public final int holeHeight = 32;

    public void add(Ball b) {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw a hole
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(
                (double) super.getWidth() / 2,
                (double) super.getHeight() / 2,
                holeWidth, holeHeight));

        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            if (b.fell) {
                balls.remove(i);
                i--;
            } else {
                b.draw(g2);
            }
        }
    }
}
