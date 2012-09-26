package com.example.oob.chance;

import org.junit.Test;

import static com.example.oob.chance.Chance.newChance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 9/25/12 at 3:09 PM
 */
public class TestChance {
    @Test
    public void twoChancesWithSameValueShouldBeEqual() {
        assertThat(newChance(0.5), equalTo(newChance(0.5)));
    }

    @Test
    public void twoChancesWithDifferentValuesShouldBeUnequal() {
        assertThat(newChance(0.5), not(equalTo(newChance(0.51))));
    }

    @Test
    public void shouldCorrectlyDetermineProbabilityOfEventNotOccurring() {
        assertThat(newChance(0.5).not(), equalTo(newChance(0.5)));
        assertThat(newChance(0.3).not(), equalTo(newChance(0.7)));
        assertThat(newChance(0.7).not(), equalTo(newChance(0.3)));
        assertThat(newChance(0).not(), equalTo(newChance(1)));
    }

    @Test(expected = IllegalProbabilityValueException.class)
    public void shouldNotAllowProbabilityLessThanZero() {
        newChance(-0.001);
    }

    @Test(expected = IllegalProbabilityValueException.class)
    public void shouldNotAllowProbabilityValueGreaterThanOne() {
        newChance(1.001);
    }

    @Test
    public void shouldCorrectlyDetermineIntersectionOfTwoProbabilities() {
        assertThat(newChance(0.5).and(newChance(0.5)), equalTo(newChance(0.25)));
        assertThat(newChance(0.9).and(newChance(0.1)), equalTo(newChance(0.09)));
    }

    @Test
    public void shouldCorrectlyDetermineUnionOfTwoProbabilities() {
        assertThat(newChance(0.5).or(newChance(0.5)), equalTo(newChance(0.75)));
        assertThat(newChance(0.9).or(newChance(0.1)), equalTo(newChance(0.91)));
    }

    @Test
    public void shouldCorrectlyDetermineUnionOfTwoProbabilitiesUsingDeMorgansLaw() {
        assertThat(newChance(0.5).dor(newChance(0.5)), equalTo(newChance(0.75)));
        assertThat(newChance(0.9).dor(newChance(0.1)), equalTo(newChance(0.91)));
    }
}
