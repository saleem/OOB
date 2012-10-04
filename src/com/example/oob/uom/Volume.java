package com.example.oob.uom;

import java.text.DecimalFormat;

/**
 * Created by Saleem Siddiqui on 10/3/12 at 10:15 PM
 */
public class Volume {
    private final Unit unit;
    private final double magnitude;

    public static enum Unit {
        US_GALLON(3.78541D),
        LITER(1D),
        IMP_GALLON(4.54609D);

        private double literFactor;

        Unit(double literFactor) {
            this.literFactor = literFactor;
        }
    }

    public static Volume createVolume(Unit unit, double magnitude) {
        return new Volume(unit, magnitude);
    }

    private Volume(Unit unit, double magnitude) {
        this.unit = unit;
        this.magnitude = magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;
        return compare(volume) == 0;
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
        sb.append("Volume");
        sb.append("{unit=").append(unit);
        sb.append(", magnitude=").append(magnitude);
        sb.append('}');
        return sb.toString();
    }

    private int compare(Volume other) {
        return Double.compare(convertToLiters(), other.convertToLiters());
    }

    private double convertToLiters() {
        return Double.valueOf(SCALE.format(unit.literFactor * magnitude));
    }

    private static DecimalFormat SCALE = new DecimalFormat("#.######");
}
