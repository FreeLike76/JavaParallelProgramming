package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BallCanvasHole {
    public int x;
    public int y;
    private static final int RADIUS = 16;

    public BallCanvasHole(int x, int y){
        this.x = x;
        this.y = y;

    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(x, y, RADIUS * 2, RADIUS * 2));
    }

    public boolean isIn(int ballX, int ballY){
        return Math.pow((ballX - x), 2) + Math.pow((ballY - y), 2) < Math.pow(RADIUS, 2);
    }
}
