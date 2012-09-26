package com.example.oob.chance;

/**
 * Created by Saleem Siddiqui on 9/25/12 at 3:16 PM
 */
public class Chance {
    private double value;

    public Chance(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        if (Double.compare(chance.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }

    public Chance not() {
        return new Chance(1 - value);
    }
}
