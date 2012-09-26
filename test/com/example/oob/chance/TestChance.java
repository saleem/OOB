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
    }
}
