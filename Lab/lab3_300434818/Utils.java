/**
 * Utility class containing static methods for string manipulation.
 * 
 * @author Your Name
 */
public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in   an array of Strings that will remain unchanged
     * @param what an array of words to be replaced
     * @param with an array of replacement words
     * @return a new array identical to 'in' except that all occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     * If any of the input arrays are null, contain null elements, or if 'what' and 'with'
     * are not of the same length, the method returns null.
     */
    public static String[] findAndReplace(String[] in, String[] what, String[] with) {
        // Validate preconditions
        if (in == null || what == null || with == null || what.length != with.length) {
            return null;
        }

        // Check for null elements in arrays
        for (String s : in) {
            if (s == null) return null;
        }
        for (String s : what) {
            if (s == null) return null;
        }
        for (String s : with) {
            if (s == null) return null;
        }

        // Create a new array to store the modified elements
        String[] out = new String[in.length];

        // Process each word in the input array
        for (int i = 0; i < in.length; i++) {
            boolean replaced = false;
            for (int j = 0; j < what.length; j++) {
                if (in[i].equals(what[j])) { // If word found in 'what', replace it
                    out[i] = with[j];
                    replaced = true;
                    break; // Only use the first match
                }
            }
            if (!replaced) {
                out[i] = in[i]; // Keep original if no match found
            }
        }

        return out;
    }
}
