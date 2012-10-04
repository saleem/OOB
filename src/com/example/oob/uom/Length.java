package com.example.oob.uom;

import java.text.DecimalFormat;

/**
 * Created by Saleem Siddiqui on 10/3/12 at 10:15 PM
 */
public class Length {
    private final Unit unit;
    private final double magnitude;

    public static enum Unit {
        FOOT(12D),
        INCH(1D),
        CM(0.39370079) ,
        MM(0.039370079);

        private double inchFactor;

        Unit(double inchFactor) {
            this.inchFactor = inchFactor;
        }

        public double toInches() {
            return inchFactor;
        }
    }

    public static Length createLength(Unit unit, double magnitude) {
        return new Length(unit, magnitude);
    }

    private Length(Unit unit, double magnitude) {
        this.unit = unit;
        this.magnitude = magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;

        return compare(length) == 0;
    }

    public int compare(Length other) {
        return Double.compare(convertToInches(), other.convertToInches());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = unit.hashCode();
        temp = magnitude != +0.0d ? Double.doubleToLongBits(magnitude) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Length");
        sb.append("{unit=").append(unit);
        sb.append(", magnitude=").append(magnitude);
        sb.append('}');
        return sb.toString();
    }

    private double convertToInches() {
        return Double.valueOf(SCALE.format(unit.inchFactor * magnitude));
    }

    private static DecimalFormat SCALE = new DecimalFormat("#.######");
}
