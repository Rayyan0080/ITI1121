public class Q3_ReverseSortDemo {

    public static void main(String[] args) {
        char[] unorderedLetters = {'b', 'm', 'z', 'a', 'u'};
        reverseSort(unorderedLetters);
        for (char c : unorderedLetters) {
            System.out.print(c);
        }
    }

    public static void reverseSort(char[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] > values[i]) {
                    char temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }
}
