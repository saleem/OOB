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
    public void shouldBeAbleToCompareFeetToOtherLengthUnits() {
        assertThat(UnitOfMeasure.create(1.1, FOOT), is(UnitOfMeasure.create(1.1, FOOT)));
        assertThat(UnitOfMeasure.create(1.1, FOOT), is(UnitOfMeasure.create(13.2, INCH)));
        assertThat(UnitOfMeasure.create(1.1, FOOT), is(UnitOfMeasure.create(33.5279997787, CM)));
        assertThat(UnitOfMeasure.create(1.1, FOOT), is(UnitOfMeasure.create(335.279997787, MM)));
    }

    @Test
    public void shouldBeAbleToCompareInchesToOtherLengthUnits() {
        assertThat(UnitOfMeasure.create(1.1, INCH), is(UnitOfMeasure.create(1.1, INCH)));
        assertThat(UnitOfMeasure.create(1.1, INCH), is(UnitOfMeasure.create(0.09166666666, FOOT)));
        assertThat(UnitOfMeasure.create(1.1, INCH), is(UnitOfMeasure.create(2.7939999815, CM)));
        assertThat(UnitOfMeasure.create(1.1, INCH), is(UnitOfMeasure.create(27.939999815, MM)));
    }

    @Test
    public void shouldBeAbleToCompareCentimetersToOtherLengthUnits() {
        assertThat(UnitOfMeasure.create(1.1, CM), is(UnitOfMeasure.create(0.433070869, INCH)));
        assertThat(UnitOfMeasure.create(1.1, CM), is(UnitOfMeasure.create(0.0360892390833, FOOT)));
        assertThat(UnitOfMeasure.create(1.1, CM), is(UnitOfMeasure.create(1.1, CM)));
        assertThat(UnitOfMeasure.create(1.1, CM), is(UnitOfMeasure.create(11, MM)));
    }

    @Test
    public void shouldBeAbleToCompareMillimetersToOtherLengthUnits() {
        assertThat(UnitOfMeasure.create(1.1, MM), is(UnitOfMeasure.create(0.0433070869, INCH)));
        assertThat(UnitOfMeasure.create(1.1, MM), is(UnitOfMeasure.create(0.00360892390833, FOOT)));
        assertThat(UnitOfMeasure.create(1.1, MM), is(UnitOfMeasure.create(0.11, CM)));
        assertThat(UnitOfMeasure.create(1.1, MM), is(UnitOfMeasure.create(1.1, MM)));
    }

}
