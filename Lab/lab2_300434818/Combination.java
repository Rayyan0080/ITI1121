public class Combination {
    // Instance variables
    private int first;
    private int second;
    private int third;

    // Constructor
    public Combination(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Equals method to compare combinations
    public boolean equals(Combination other) {
        if (other == null) {
            return false;
        }
        return this.first == other.first && this.second == other.second && this.third == other.third;
    }

    // String representation of the combination
    public String toString() {
        return first + ":" + second + ":" + third;
    }
}
