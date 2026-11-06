import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)
    private static class Node {
        private Comparable value;
        private Node previous;
        private Node next;

        private Node(Comparable value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables
    private Node head;
    
    // Representation of the empty list with dummy node
    public OrderedList() {
        // Create a dummy node that points to itself
        head = new Node(null, null, null);
        head.next = head;
        head.previous = head;
    }

    // Calculates the size of the list
    public int size() {
        int count = 0;
        Node current = head.next;
        
        while (current != head) {
            count++;
            current = current.next;
        }
        
        return count;
    }

    public Object get(int pos) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds");
        }
        
        Node current = head.next;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        
        return current.value;
    }

    // Adding an element while preserving the order
    public boolean add(Comparable o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot add null element");
        }
        
        // Find the position where the new element should be inserted
        Node current = head.next;
        
        // Skip all elements that are smaller than o
        while (current != head && current.value.compareTo(o) < 0) {
            current = current.next;
        }
        
        // Insert the new node before current
        Node newNode = new Node(o, current.previous, current);
        current.previous.next = newNode;
        current.previous = newNode;
        
        return true;
    }

    // Removes one item from the position pos
    public void remove(int pos) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds");
        }
        
        // Find the node to remove
        Node current = head.next;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        
        // Remove the node
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously
    public void merge(OrderedList other) {
        if (other == null || other.size() == 0) {
            return; // Nothing to merge
        }
        
        Node thisCurrent = head.next;
        Node otherCurrent = other.head.next;
        
        while (otherCurrent != other.head) {
            // Find the position where the element from other should be inserted
            while (thisCurrent != head && thisCurrent.value.compareTo(otherCurrent.value) < 0) {
                thisCurrent = thisCurrent.next;
            }
            
            // Create a new node with the value from other list
            Node newNode = new Node(otherCurrent.value, thisCurrent.previous, thisCurrent);
            
            // Insert the new node before thisCurrent
            thisCurrent.previous.next = newNode;
            thisCurrent.previous = newNode;
            
            // Move to the next element in other list
            otherCurrent = otherCurrent.next;
        }
    }
}