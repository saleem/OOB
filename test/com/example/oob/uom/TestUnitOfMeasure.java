package com.example.oob.uom;

import org.junit.Test;

import static com.example.oob.uom.UnitOfMeasure.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 10/5/12 at 3:46 AM
 */
public class TestUnitOfMeasure {
    @Test
    public void compareFeetToOtherLengthUnits() {
        assertThat(createUOM(1.1, FOOT), is(createUOM(1.1, FOOT)));
        assertThat(createUOM(1.1, FOOT), is(createUOM(13.2, INCH)));
        assertThat(createUOM(1.1, FOOT), is(createUOM(33.5279997787, CM)));
        assertThat(createUOM(1.1, FOOT), is(createUOM(335.279997787, MM)));
    }

    @Test
    public void compareInchesToOtherLengthUnits() {
        assertThat(createUOM(1.1, INCH), is(createUOM(1.1, INCH)));
        assertThat(createUOM(1.1, INCH), is(createUOM(0.09166666666, FOOT)));
        assertThat(createUOM(1.1, INCH), is(createUOM(2.7939999815, CM)));
        assertThat(createUOM(1.1, INCH), is(createUOM(27.939999815, MM)));
    }

    @Test
    public void compareCentimetersToOtherLengthUnits() {
        assertThat(createUOM(1.1, CM), is(createUOM(0.433070869, INCH)));
        assertThat(createUOM(1.1, CM), is(createUOM(0.0360892390833, FOOT)));
        assertThat(createUOM(1.1, CM), is(createUOM(1.1, CM)));
        assertThat(createUOM(1.1, CM), is(createUOM(11, MM)));
    }

    @Test
    public void compareMillimetersToOtherLengthUnits() {
        assertThat(createUOM(1.1, MM), is(createUOM(0.0433070869, INCH)));
        assertThat(createUOM(1.1, MM), is(createUOM(0.00360892390833, FOOT)));
        assertThat(createUOM(1.1, MM), is(createUOM(0.11, CM)));
        assertThat(createUOM(1.1, MM), is(createUOM(1.1, MM)));
    }

    @Test
    public void compareLitersToOtherVolumeUnits() {
        assertThat(createUOM(1.1, LITER), is(createUOM(1.1, LITER)));
        assertThat(createUOM(1.1, LITER), is(createUOM(0.290589394543, US_GALLON)));
        assertThat(createUOM(1.1, LITER), is(createUOM(0.241966173128, IMP_GALLON)));
    }

    @Test
    public void compareUSGallonsToOtherVolumeUnits() {
        assertThat(createUOM(1.1, US_GALLON), is(createUOM(4.163951, LITER)));
        assertThat(createUOM(1.1, US_GALLON), is(createUOM(1.1, US_GALLON)));
        assertThat(createUOM(1.1, US_GALLON), is(createUOM(0.915941171424, IMP_GALLON)));
    }

    @Test
    public void shouldBeAbleToCompareImperialGallonsToOtherVolumeUnits() {
        assertThat(createUOM(1.1, IMP_GALLON), is(createUOM(5.000699, LITER)));
        assertThat(createUOM(1.1, IMP_GALLON), is(createUOM(1.321045540641, US_GALLON)));
        assertThat(createUOM(1.1, IMP_GALLON), is(createUOM(1.1, IMP_GALLON)));
    }

    @Test
    public void shouldBeAbleToCompareKelvinToOtherTemperatureUnits() {
        assertThat(createUOM(1.1, KELVIN), is(createUOM(1.1, KELVIN)));
        assertThat(createUOM(1.1, KELVIN), is(createUOM(-272.05, CELSIUS)));
        assertThat(createUOM(1.1, KELVIN), is(createUOM(-457.69, FAHRENHEIT)));
    }

    @Test
    public void shouldBeAbleToCompareCelsiusToOtherTemperatureUnits() {
        assertThat(createUOM(1.1, CELSIUS), is(createUOM(274.25, KELVIN)));
        assertThat(createUOM(1.1, CELSIUS), is(createUOM(1.1, CELSIUS)));
        assertThat(createUOM(1.1, CELSIUS), is(createUOM(33.98, FAHRENHEIT)));
    }

    @Test
    public void shouldBeAbleToCompareFahrenheitToOtherTemperatureUnits() {
        assertThat(createUOM(1.1, FAHRENHEIT), is(createUOM(255.983333333, KELVIN)));
        assertThat(createUOM(1.1, FAHRENHEIT), is(createUOM(-17.166666666, CELSIUS)));
        assertThat(createUOM(1.1, FAHRENHEIT), is(createUOM(1.1, FAHRENHEIT)));
    }

    private UnitOfMeasure createUOM(double magnitude, UnitOfMeasure.Unit unit) {
        return UnitOfMeasure.create(magnitude, unit);
    }
}
