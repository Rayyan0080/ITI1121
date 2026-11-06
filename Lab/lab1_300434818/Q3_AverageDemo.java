public class Q3_AverageDemo {

    public static void main(String[] args) {
        double[] valuesArray = {100.0, 34.0, 72.0, 56.0, 82.0, 67.0, 94.0};
        System.out.println("The average is: " + calculateAverage(valuesArray));
    }

    public static double calculateAverage(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}
