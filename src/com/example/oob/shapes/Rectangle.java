package com.example.oob.shapes;

/**
 * Created by Saleem Siddiqui on 9/18/12 at 12:27 PM
 */
public class Rectangle {
    private final int length;
    private final int width;

    private Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle createRectangle(int length, int width) {
        return new Rectangle(length, width);
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public int area() {
        return length * width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (length != rectangle.length) return false;
        if (width != rectangle.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + width;
        return result;
    }

    public int perimeter() {
        return 2 * (length + width);
    }
}
