package com.saleem_siddiqui.oob.shapes;

/**
 * Created by Saleem Siddiqui on 9/18/12 at 12:27 PM
 */
public class Rectangle {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return length * width;
    }
}
