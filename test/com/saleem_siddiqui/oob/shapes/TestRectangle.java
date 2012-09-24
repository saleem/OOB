package com.saleem_siddiqui.oob.shapes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 9/18/12 at 11:06 AM
 */
public class TestRectangle {
    @Test
    public void shouldComputeAreaOfRectangle() {
        assertThat(new Rectangle(4, 5).area(), is(20));
    }
}
