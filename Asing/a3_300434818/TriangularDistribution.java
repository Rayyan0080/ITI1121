public class TriangularDistribution {
    int a, c, b;

    public TriangularDistribution(int a, int c, int b) {
        if (a < c && c < b) {
            this.a = a;
            this.c = c;
            this.b = b;
        } else {
            throw new IllegalArgumentException("Invalid range: must be a < c < b");
        }
    }

    public Rational pdf(int x) {
        if (x < a) return Rational.zero;
        if (x >= a && x <= c) return new Rational(2 * (x - a), (b - a) * (c - a));
        if (x > c && x <= b) return new Rational(2 * (b - x), (b - a) * (b - c));
        return Rational.zero;
    }
}
