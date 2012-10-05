package com.example.oob.uom;

import java.text.DecimalFormat;

import static com.example.oob.uom.UnitOfMeasure.PhysicalProperty.*;

/**
 * Created by Saleem Siddiqui on 10/5/12 at 3:47 AM
 */
public class UnitOfMeasure {

    private final double magnitude;
    private final Unit unit;
    private static DecimalFormat SCALE = new DecimalFormat("#.######");


    /**
     * Physical properties that can be measured.
     */
    public static enum PhysicalProperty {
        LENGTH, VOLUME, TEMPERATURE
    }

    /**
     * Units for various PhysicalProperty objects.
     * Each Unit has three attributes:
     * <ol>
     *     <li>Factor: a positive number representing the ratio of this unit to the canonical unit (always 1 for canonical unit)</li>
     *     <li>Offset: a negative, zero or positive number which must be added after the factor is applied to the canonical unit
     *         to derive this unit (always 0 for canonical unit)</li>
     *     <li>PhysicalProperty: the PhysicalProperty enum that this unit measures</li>
     * </ol>
     */
    public static enum Unit {
        INCH(1D, 0, LENGTH),
        FOOT(12D, 0, LENGTH),
        CM(0.39370079D, 0, LENGTH),
        MM(0.039370079D, 0, LENGTH),

        LITER(1D, 0, VOLUME),
        US_GALLON(3.78541D, 0, VOLUME),
        IMP_GALLON(4.54609D, 0, VOLUME),

        KELVIN(1D, 0, TEMPERATURE),
        CELSIUS(1D, -273.15D, TEMPERATURE),
        FAHRENHEIT(1.8D, -459.67D, TEMPERATURE);

        public final double factor;
        public final double offset;
        private final PhysicalProperty physicalProperty;

        Unit(double factor, double offset, PhysicalProperty physicalProperty) {
            this.factor = factor;
            this.offset = offset;
            this.physicalProperty = physicalProperty;
        }

        public Unit getCanonicalUnit(PhysicalProperty physicalProperty) {
            for (Unit unit : Unit.values()) {
                if (unit.physicalProperty == physicalProperty && unit.factor == 1D && unit.offset == 0D) {
                    return unit;
                }
            }
            throw new RuntimeException("Configuration Error: No canonical unit (with a factor of 1 and offset of 0) found for Physical Property " + physicalProperty + "!");
        }
    }

    public static UnitOfMeasure create(double magnitude, Unit unit) {
        return new UnitOfMeasure(magnitude, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitOfMeasure that = (UnitOfMeasure) o;
        if (unit.physicalProperty != that.unit.physicalProperty) return false;
        if (Double.compare(that.canonicalMagnitude(), canonicalMagnitude()) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = magnitude != +0.0d ? Double.doubleToLongBits(magnitude) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + unit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UnitOfMeasure");
        sb.append("{magnitude=").append(magnitude);
        sb.append(", unit=").append(unit);
        sb.append('}');
        return sb.toString();
    }

    private UnitOfMeasure(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    private double canonicalMagnitude() {
        return Double.valueOf(SCALE.format(magnitude * unit.factor +  unit.offset));
    }
}
