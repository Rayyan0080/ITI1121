/**
 * This class provides an implementation of a triangular probabilistic
 * distribution. A simple mathematical explanation of this probability
 * distribution is available on Wikipedia at:
 * https://en.wikipedia.org/wiki/Triangular_distribution
 *
 * @author Mehrdad Sabetzadeh
 */
public class TriangularDistribution {

    int a, c, b; // Lower limit (a), mode (c), and upper limit (b)

    /**
     * Constructor for TriangularDistribution.
     * Verifies that a < c < b holds.
     *
     * @param a Lower limit of the distribution
     * @param c Mode (peak of the triangle)
     * @param b Upper limit of the distribution
     */
    public TriangularDistribution(int a, int c, int b) {
        if (a >= c || c >= b) {
            throw new IllegalArgumentException("Invalid parameters: Ensure a < c < b");
        }
        this.a = a;
        this.c = c;
        this.b = b;
    }

    /**
     * Probability Density Function (PDF) for triangular distribution.
     *
     * @param x The value at which the PDF is calculated
     * @return The probability density at point x as a Rational number
     */
    public Rational pdf(int x) {
        if (x < a || x > b) {
            return Rational.zero; // Zero probability outside the range [a, b]
        }

        if (x >= a && x < c) {
            // Ascending part of the triangle: (2 * (x - a)) / ((b - a) * (c - a))
            return new Rational(2 * (x - a), (b - a) * (c - a));
        }

        if (x == c) {
            // Peak of the triangle: 2 / (b - a)
            return new Rational(2, (b - a));
        }

        if (x > c && x <= b) {
            // Descending part of the triangle: (2 * (b - x)) / ((b - a) * (b - c))
            return new Rational(2 * (b - x), (b - a) * (b - c));
        }

        return Rational.zero; // Catch-all (shouldn't be reached)
    }

    /**
     * Test cases to validate the triangular distribution implementation.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String args[]) {
        // First distribution: (0, 5, 10)
        System.out.println("=========== TriangularDistribution(0, 5, 10) =============");
        TriangularDistribution dist0 = new TriangularDistribution(0, 5, 10);
        Rational sum0 = new Rational(0, 1); // Accumulate probabilities

        for (int i = 0; i <= 10; i++) {
            Rational p = dist0.pdf(i);
            sum0 = sum0.plus(p);
            System.out.println("pdf(" + i + ") = " + p);
        }

        System.out.println();
        System.out.println("Integral (Sum) = " + sum0);
        System.out.println();

        // Second distribution: (0, 50, 100)
        System.out.println("=========== TriangularDistribution(0, 50, 100) =============");
        TriangularDistribution dist1 = new TriangularDistribution(0, 50, 100);
        Rational sum1 = new Rational(0, 1);

        for (int i = 0; i <= 100; i++) {
            Rational p = dist1.pdf(i);
            sum1 = sum1.plus(p);
            System.out.println("pdf(" + i + ") = " + p);
        }

        System.out.println();
        System.out.println("Integral (Sum) = " + sum1);
        System.out.println();

        // Third distribution: (0, 10, 50)
        System.out.println("=========== TriangularDistribution(0, 10, 50) =============");
        TriangularDistribution dist2 = new TriangularDistribution(0, 10, 50);
        Rational sum2 = new Rational(0, 1);

        for (int i = 0; i <= 50; i++) {
            Rational p = dist2.pdf(i);
            sum2 = sum2.plus(p);
            System.out.println("pdf(" + i + ") = " + p);
        }

        System.out.println();
        System.out.println("Integral (Sum) = " + sum2);
    }
}
