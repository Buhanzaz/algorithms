package com.buhanzaz.chapter_1._1_base_model_programming.experiments;

import java.util.*;

public class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational that) {
        int newNumerator;
        int newDenominator;

        if (this.denominator == that.denominator) {
            newNumerator = this.numerator + that.numerator;
            return createShortenedFraction(newNumerator, this.denominator);
        } else {
            newNumerator = this.numerator * that.denominator + that.numerator * this.denominator;
            newDenominator = this.denominator * that.denominator;
            return createShortenedFraction(newNumerator, newDenominator);
        }
    }

    public Rational minus(Rational that) {
        int newNumerator;
        int newDenominator;

        if (this.denominator == that.denominator) {
            newNumerator = this.numerator - that.numerator;
            return createShortenedFraction(newNumerator, this.denominator);
        } else {
            newNumerator = this.numerator * that.denominator - that.numerator * this.denominator;
            newDenominator = this.denominator * that.denominator;
            return createShortenedFraction(newNumerator, newDenominator);
        }
    }

    public Rational times(Rational b) {
        int newNumerator = this.numerator * b.numerator;
        int newDenominator = this.denominator * b.denominator;

        if (isAbbreviated(newNumerator, newDenominator)) {
            int factor = getMaxFactors(newNumerator, newDenominator);
            return new Rational(newNumerator / factor, newDenominator / factor);
        } else {
            return new Rational(newNumerator, newDenominator);
        }

    }

    private boolean isAbbreviated(int a, int b) {
        return (a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0);
    }

    public Rational divides(Rational b) {
        return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
    }

    private int getMaxFactors(int firstInt, int secondInt) {
        Set<Integer> factors = new HashSet<>();
        byte step = getStep(firstInt);

        for (int i = 1; i < Math.sqrt(Math.min(firstInt, secondInt)); i += step) {
            if (secondInt % i == 0 && firstInt % i == 0) {
                factors.add(i);
                factors.add(secondInt / i);
            }
        }

        return Collections.max(factors);
    }

    private byte getStep(int num) {
        return (byte) (num % 2 == 0 ? 1 : 2);
    }

    private Rational createShortenedFraction(int numerator, int denominator) {
        if (!isAbbreviated(numerator, denominator)) {
            return new Rational(numerator, denominator);
        } else {
            int divider = getMaxFactors(numerator, denominator);
            return new Rational(numerator / divider, denominator / divider);
        }
    }
}
