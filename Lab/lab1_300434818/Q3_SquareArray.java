public class Q3_SquareArray {

    public static int[] createArray(int size) {
        int[] squares = new int[size];
        for (int i = 0; i < size; i++) {
            squares[i] = i * i;
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] squares = createArray(13);
        for (int i = 0; i < squares.length; i++) {
            System.out.println("The square of " + i + " is: " + squares[i]);
        }
    }
}

