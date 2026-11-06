/**
 * A generic implementation of a singly linked list
 * @param <E> the type of elements in this list
 */
public class SinglyLinkedList<E> implements List<E> {
    
    /**
     * Node class for the SinglyLinkedList
     * @param <T> the type of value stored in the node
     */
    private static class Node<T> {
        private T value;
        private Node<T> next;
        
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private Node<E> head;
    private int size;
    
    /**
     * Constructor for SinglyLinkedList
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Adds the specified element to the end of this list
     * @param element the element to add
     * @return true if the element was added, false otherwise
     */
    public boolean add(E element) {
        if (head == null) {
            head = new Node<E>(element, null);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(element, null);
        }
        size++;
        return true;
    }
    
    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Counts the number of elements between fromElement and toElement (inclusive)
     * @param fromElement the starting element
     * @param toElement the ending element
     * @return the number of elements between fromElement and toElement (inclusive)
     */
    public int count(E fromElement, E toElement) {
        // Handle null cases first
        if (fromElement == null) {
            return 0; // Can't start counting from a null element
        }
        
        return count(head, fromElement, toElement, 0);
    }
    
    /**
     * Recursive helper method for count
     * @param p the current node
     * @param fromElement the starting element
     * @param toElement the ending element
     * @param count the current count (used in recursion)
     * @return the number of elements between fromElement and toElement (inclusive)
     */
    private int count(Node<E> p, E fromElement, E toElement, int count) {
        // Base case: end of list
        if (p == null) {
            return 0;
        }
        
        // If we haven't found fromElement yet (count == 0)
        if (count == 0) {
            // Check if current node is fromElement
            if ((fromElement == null && p.value == null) || 
                (fromElement != null && fromElement.equals(p.value))) {
                // Found fromElement, start counting and include it in the count
                if (toElement == null) {
                    // If toElement is null, count from here to the end of the list
                    return 1 + count(p.next, fromElement, toElement, count + 1);
                } else if (toElement.equals(p.value)) {
                    // If fromElement equals toElement
                    return 1;
                } else {
                    return 1 + count(p.next, fromElement, toElement, count + 1);
                }
            } else {
                // Keep looking for fromElement
                return count(p.next, fromElement, toElement, 0);
            }
        } 
        // If we're counting (already found fromElement)
        else {
            // Check if current node is toElement
            if ((toElement == null && p.value == null) || 
                (toElement != null && toElement.equals(p.value))) {
                // Found toElement, include it in the count and finish
                return 1;
            } else {
                // Keep counting
                if (p.next == null || toElement == null) {
                    // If we've reached the end of the list or toElement is null
                    return 1 + count(p.next, fromElement, toElement, count + 1);
                } else {
                    return 1 + count(p.next, fromElement, toElement, count + 1);
                }
            }
        }
    }
    
    /**
     * Returns a string representation of this list
     * @return a string representation of this list
     */
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Node<E> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}