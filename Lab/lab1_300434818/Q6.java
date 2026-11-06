import java.util.Arrays;
import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[10];

        System.out.println("Enter 10 grades:");
        for (int i = 0; i < grades.length; i++) {
            grades[i] = scanner.nextDouble();
        }

        System.out.println("Average: " + calculateAverage(grades));
        System.out.println("Median: " + calculateMedian(grades));
        System.out.println("Number Passed: " + calculateNumberPassed(grades));
        System.out.println("Number Failed: " + calculateNumberFailed(grades));

        scanner.close();
    }

    public static double calculateAverage(double[] notes) {
        double sum = 0;
        for (double note : notes) {
            sum += note;
        }
        return sum / notes.length;
    }

    public static double calculateMedian(double[] notes) {
        Arrays.sort(notes);
        int mid = notes.length / 2;
        return notes.length % 2 == 0 ? (notes[mid - 1] + notes[mid]) / 2 : notes[mid];
    }

    public static int calculateNumberFailed(double[] notes) {
        int count = 0;
        for (double note : notes) {
            if (note < 50) count++;
        }
        return count;
    }

    public static int calculateNumberPassed(double[] notes) {
        int count = 0;
        for (double note : notes) {
            if (note >= 50) count++;
        }
        return count;
    }
}
