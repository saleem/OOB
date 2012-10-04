package com.example.oob.uom;

import org.junit.Test;

import static com.example.oob.uom.Length.createLength;
import static com.example.oob.uom.Length.Unit.CM;
import static com.example.oob.uom.Length.Unit.FOOT;
import static com.example.oob.uom.Length.Unit.INCH;
import static com.example.oob.uom.Length.Unit.MM;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 10/3/12 at 10:13 PM
 */
public class TestLength {
    @Test
    public void shouldConvertBetweenFeetAndInches() {
        assertThat(createLength(FOOT, 1), is(createLength(INCH, 12)));
        assertThat(createLength(INCH, 12), is(createLength(FOOT, 1)));
        assertThat(createLength(FOOT, 0.5), is(createLength(INCH, 6)));
        assertThat(createLength(INCH, 6), is(createLength(FOOT, 0.5)));
        assertThat(createLength(FOOT, 0), is(createLength(INCH, 0)));
        assertThat(createLength(INCH, 0), is(createLength(FOOT, 0)));
    }

    @Test
    public void shouldConvertBetweenCentimetersAndInches() {
        assertThat(createLength(CM, 2.54), is(createLength(INCH, 1)));
        assertThat(createLength(INCH, 1), is(createLength(CM, 2.54)));
        assertThat(createLength(INCH, 0.393701), is(createLength(CM, 1)));
        assertThat(createLength(CM, 1), is(createLength(INCH, 0.393701)));
    }

    @Test
    public void shouldConvertBetweenMillimetersAndInches() {
        assertThat(createLength(MM, 25.4), is(createLength(INCH, 1)));
        assertThat(createLength(INCH, 1), is(createLength(MM, 25.4)));
        assertThat(createLength(INCH, 0.0393701), is(createLength(MM, 1)));
        assertThat(createLength(MM, 1), is(createLength(INCH, 0.0393701)));
    }

    @Test
    public void shouldConvertBetweenCentimetersAndMillimeters() {
        assertThat(createLength(CM, 1), is(createLength(MM, 10)));
        assertThat(createLength(MM, 1000), is(createLength(CM, 100)));
        assertThat(createLength(CM, 0.01), is(createLength(MM, 0.1)));
    }
}
