/**
 * A class representing rational numbers (fractions).
 * Each rational number consists of a numerator and a denominator.
 * This class ensures that the fraction is always stored in its reduced form.
 * 
 * @author Your Name
 */
public class Rational {

    private int numerator;
    private int denominator;

    /**
     * Constructs a Rational number with the given numerator.
     * Assumes a denominator of 1.
     *
     * @param numerator The numerator of the rational number.
     */
    public Rational(int numerator) {
        this(numerator, 1);
    }

    /**
     * Constructs a Rational number with the given numerator and denominator.
     * The fraction is automatically reduced to its simplest form.
     *
     * @param numerator   The numerator of the rational number.
     * @param denominator The denominator of the rational number.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        // Ensure denominator is always positive
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    /**
     * Gets the numerator of this Rational number.
     *
     * @return The numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Gets the denominator of this Rational number.
     *
     * @return The denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Adds this Rational number to another Rational number.
     *
     * @param other The Rational number to add.
     * @return A new Rational number representing the sum.
     */
    public Rational plus(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Adds two Rational numbers and returns a new Rational number.
     *
     * @param a The first Rational number.
     * @param b The second Rational number.
     * @return A new Rational number representing the sum of a and b.
     */
    public static Rational plus(Rational a, Rational b) {
        return a.plus(b);
    }

    /**
     * Reduces the fraction to its simplest form.
     * Ensures that the denominator is always positive.
     */
    private void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    /**
     * Computes the greatest common divisor (GCD) of two numbers using Euclid's algorithm.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The greatest common divisor of a and b.
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Compares this Rational number with another.
     *
     * @param other The Rational number to compare to.
     * @return A negative integer if this is less than other, 0 if equal, and a positive integer if greater.
     */
    public int compareTo(Rational other) {
        return this.numerator * other.denominator - other.numerator * this.denominator;
    }

    /**
     * Checks if this Rational number is equal to another.
     *
     * @param other The Rational number to compare with.
     * @return True if both Rational numbers are equal, false otherwise.
     */
    public boolean equals(Rational other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    /**
     * Returns a string representation of this Rational number.
     *
     * @return A string representation of this Rational number in the format "numerator/denominator".
     *         If the denominator is 1, only the numerator is returned.
     */
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }
}
