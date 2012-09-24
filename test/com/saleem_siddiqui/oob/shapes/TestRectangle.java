package com.saleem_siddiqui.oob.shapes;

import org.junit.Test;

import static com.saleem_siddiqui.oob.shapes.Rectangle.createRectangle;
import static com.saleem_siddiqui.oob.shapes.Rectangle.createSquare;
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
    public void rectangleAndSquareWithSameDimensionsShouldBeEqual() {
        assertThat(createRectangle(5, 5), equalTo(createSquare(5)));
    }
}
