public class Q5 {

    public static void main(String[] args) {
        boolean[] test = new boolean[8];

        // Test for isPrime
        test[0] = (isPrime(0) == false);
        test[1] = (isPrime(2) == true);
        test[2] = (isPrime(7) == true);
        test[3] = (isPrime(15) == false);

        // Test for Fibonacci
        test[4] = (getFibonacci(1) == 1);
        test[5] = (getFibonacci(3) == 2);
        test[6] = (getFibonacci(5) == 5);
        test[7] = (getFibonacci(8) == 21);

        for (int i = 0; i < test.length; i++) {
            System.out.println("test " + i + (test[i] ? " passed" : " failed"));
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static int getFibonacci(int position) {
        if (position == 0) return 0;
        if (position == 1) return 1;

        int prev1 = 0, prev2 = 1, result = 0;

        for (int i = 2; i <= position; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
}
