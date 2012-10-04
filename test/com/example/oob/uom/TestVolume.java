package com.example.oob.uom;

import org.junit.Test;

import static com.example.oob.uom.Volume.Unit.*;
import static com.example.oob.uom.Volume.createVolume;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 10/3/12 at 10:13 PM
 */
public class TestVolume {
    @Test
    public void shouldConvertBetweenLitersAndUSGallons() {
        assertThat(createVolume(US_GALLON, 1), is(createVolume(LITER, 3.78541)));
        assertThat(createVolume(US_GALLON, 0.26417218), is(createVolume(LITER, 1)));
    }

    @Test
    public void shouldConvertBetweenLitersAndImperialGallons() {
        assertThat(createVolume(IMP_GALLON, 1), is(createVolume(LITER, 4.54609)));
        assertThat(createVolume(IMP_GALLON, 0.21996925), is(createVolume(LITER, 1)));
    }

    @Test
    public void shouldConvertBetweenUSGallonsAndImperialGallons() {
        assertThat(createVolume(IMP_GALLON, 1), is(createVolume(US_GALLON, 1.200950491492335)));
        assertThat(createVolume(IMP_GALLON, 0.83267379220385), is(createVolume(US_GALLON, 1)));
    }
}
