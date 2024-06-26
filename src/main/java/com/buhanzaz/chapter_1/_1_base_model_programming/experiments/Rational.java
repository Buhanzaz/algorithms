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
            return createShortenedFraction(newNumerator, newDenominator);
        }

        return new Rational(newNumerator, newDenominator);
    }

    public Rational divides(Rational b) {
        int newNumerator = this.numerator * b.denominator;
        int newDenominator = this.denominator * b.denominator;

        if (isAbbreviated(newNumerator, newDenominator)) {
            return createShortenedFraction(newNumerator, newDenominator);
        }

        return new Rational(newNumerator, newDenominator);
    }

    private boolean isAbbreviated(int a, int b) {
        return (a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0);
    }


    private int getMaxFactors(int firstInt, int secondInt) {
        Set<Integer> factors = new HashSet<>();
        byte step = getStep(firstInt);

        for (int i = 1; i < Math.sqrt(Math.min(firstInt, secondInt)); i += step) {
            if (secondInt % i == 0 && firstInt % i == 0) {
                factors.add(i);
            }
        }

        return Collections.max(factors);
    }

    private byte getStep(int num) {
        return (byte) (num % 2 == 0 ? 1 : 2);
    }

    private Rational createShortenedFraction(int numerator, int denominator) {
        int newNumerator;
        int newDenominator;
        if (!isAbbreviated(numerator, denominator)) {
            return new Rational(numerator, denominator);
        } else {
            int divider = getMaxFactors(numerator, denominator);
            newNumerator = numerator / divider;
            newDenominator = denominator / divider;
            return new Rational(newNumerator, newDenominator);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return this.numerator == rational.numerator && this.denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numerator, this.denominator);
    }

    @Override
    public String toString() {
        return "%d\n--\n%d".formatted(this.numerator, this.denominator);
    }

    public static void main(String[] args) {
        Rational rational = new Rational(1, 2);
        Rational rational2 = new Rational(3, 4);
        Rational rational3 = rational.plus(rational2);
        System.out.println(rational3);
        System.out.println(rational);
    }
}
