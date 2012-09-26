package com.example.oob.chance;

import java.math.BigDecimal;

/**
 * Created by Saleem Siddiqui on 9/25/12 at 3:16 PM
 */
public class Chance {
    private BigDecimal value;

    private static final BigDecimal ALWAYS = BigDecimal.valueOf(1);
    private static final BigDecimal NEVER = BigDecimal.valueOf(0);

    public static Chance newChance(double value) {
        verify(value);
        return new Chance(BigDecimal.valueOf(value));
    }

    private Chance(BigDecimal value) {
        this.value = value;
    }

    public Chance not() {
        return new Chance(ALWAYS.add(value.negate()));
    }

    public Chance and(Chance chance) {
        return new Chance(value.multiply(chance.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        if (value.compareTo(chance.value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        double _value = value.doubleValue();
        long temp = _value != +0.0d ? Double.doubleToLongBits(_value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Chance");
        sb.append("{value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    private static void verify(double value) throws IllegalProbabilityValueException {
        if (value <  NEVER.doubleValue() || value > ALWAYS.doubleValue()) {
            throw new IllegalProbabilityValueException("Probability value must be in the range [0,1]");
        }
    }

}
