package com.example.oob.shapes;

import org.junit.Test;

import static com.example.oob.shapes.Rectangle.createRectangle;
import static com.example.oob.shapes.Rectangle.createSquare;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 9/18/12 at 11:06 AM
 */
public class TestRectangle {
    @Test
    public void shouldComputeAreaOfRectangle() {
        assertThat(createRectangle(4, 5).area(), is(20));
        assertThat(createRectangle(6, 7).area(), is(42));
    }

    @Test
    public void shouldComputeAreaOfSquare() {
        assertThat(createSquare(4).area(), is(16));
        assertThat(createSquare(6).area(), is(36));
    }

    @Test
    public void twoRectanglesWithSameDimensionsShouldBeEqual() {
        assertThat(createRectangle(4, 5), equalTo(createRectangle(4, 5)));
    }

    @Test
    public void twoSquaresWithSameDimensionsShouldBeEqual() {
        assertThat(createSquare(4), equalTo(createSquare(4)));
    }

    @Test
    public void rectangleAndSquareWithSameDimensionsShouldBeEqual() {
        assertThat(createRectangle(5, 5), equalTo(createSquare(5)));
        assertThat(createSquare(6), equalTo(createRectangle(6, 6)));
    }

    @Test
    public void shouldComputePerimeterOfRectangle() {
        assertThat(createRectangle(4, 5).perimeter(), is(18));
        assertThat(createRectangle(6, 7).perimeter(), is(26));
    }

    @Test
    public void shouldComputePerimeterOfSquare() {
        assertThat(createSquare(5).perimeter(), is(20));
        assertThat(createSquare(6).perimeter(), is(24));
    }

}
