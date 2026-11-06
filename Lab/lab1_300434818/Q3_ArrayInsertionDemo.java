public class Q3_ArrayInsertionDemo {

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
        int[] newArray = new int[beforeArray.length + 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == indexToInsert) {
                newArray[i] = valueToInsert;
            } else {
                newArray[i] = beforeArray[j++];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 5, 4, 7, 9, 6};
        System.out.println("Array before insertion:");
        for (int value : originalArray) {
            System.out.println(value);
        }

        int[] newArray = insertIntoArray(originalArray, 3, 15);
        System.out.println("Array after insertion of 15 at position 3:");
        for (int value : newArray) {
            System.out.println(value);
        }
    }
}
