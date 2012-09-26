package com.example.oob.chance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 9/25/12 at 3:09 PM
 */
public class TestChance {
    @Test
    public void twoChancesWithSameValueShouldBeEqual() {
        assertThat(new Chance(0.5), equalTo(new Chance(0.5)));
    }

    @Test
    public void twoChancesWithDifferentValuesShouldBeUnequal() {
        assertThat(new Chance(0.5), not(equalTo(new Chance(0.51))));
    }

    @Test
    public void shouldCorrectlyDetermineProbabilityOfEventNotOccurring() {
        assertThat(new Chance(0.5).not(), equalTo(new Chance(0.5)));
        assertThat(new Chance(0.3).not(), equalTo(new Chance(0.7)));
        assertThat(new Chance(0.6).not(), equalTo(new Chance(0.4)));
        assertThat(new Chance(0).not(), equalTo(new Chance(1)));
    }

    @Test(expected = IllegalProbabilityValueException.class)
    public void shouldNotAllowProbabilityLessThanZero() {
        new Chance(-0.001);
    }

    @Test(expected = IllegalProbabilityValueException.class)
    public void shouldNotAllowProbabilityValueGreaterThanOne() {
        new Chance(1.001);
    }
}
