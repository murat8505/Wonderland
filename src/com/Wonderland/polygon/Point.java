package com.Wonderland.polygon;

/**
 * Created by marco on 18/04/14.
 */
public class Point {
    public float x;
    public float y;
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }
}