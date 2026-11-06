/**
 * ITIStringBuffer - A class that efficiently concatenates strings using a linked list
 */
public class ITIStringBuffer {
    
    // The singly linked list that stores the strings
    private SinglyLinkedList<String> list;
    
    // Cached result of toString to avoid repeated computation
    private String cachedResult;
    
    // Flag to track if new strings have been appended since last toString call
    private boolean resultIsCurrent;
    
    /**
     * Constructor for ITIStringBuffer
     */
    public ITIStringBuffer() {
        list = new SinglyLinkedList<String>();
        cachedResult = "";
        resultIsCurrent = true;
    }
    
    /**
     * Appends a string to this ITIStringBuffer
     * @param s the string to append
     */
    public void append(String s) {
        list.add(s);
        resultIsCurrent = false;  // Mark that our cached result is now outdated
    }
    
    /**
     * Returns a string that is the concatenation of all strings added to this ITIStringBuffer
     * @return the concatenated string
     */
    public String toString() {
        // If the cached result is current, return it immediately
        if (resultIsCurrent) {
            return cachedResult;
        }
        
        // Calculate the total length of all strings in the list
        int totalLength = 0;
        for (String s : list) {
            totalLength += s.length();
        }
        
        // Create a character array of the total length
        char[] result = new char[totalLength];
        
        // Copy all strings into the character array
        int position = 0;
        for (String s : list) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                result[position++] = chars[i];
            }
        }
        
        // Create a new string from the character array and cache it
        cachedResult = new String(result);
        resultIsCurrent = true;
        
        return cachedResult;
    }
}