import java.util.NoSuchElementException;

public class BitList {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    private Node first;

    public BitList() {
        first = null;
    }

    public BitList(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (s.isEmpty()) {
            return; // Allow empty string to create empty BitList
        }

        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Input must be a string of 0s and 1s");
            }
        }

        for (char c : s.toCharArray()) {
            addFirst(Character.getNumericValue(c));
        }
    }

    public void addFirst(int bit) {
        if ((bit != ZERO) && (bit != ONE)) {
            throw new IllegalArgumentException(Integer.toString(bit));
        }
        first = new Node(bit, first);
    }

    public int removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        int saved = first.bit;
        first = first.next;
        return saved;
    }

    public Iterator iterator() {
        return new BitListIterator();
    }

    public String toString() {
        String str = "";
        if (first == null) {
            str += ZERO;
        } else {
            Node p = first;
            while (p != null) {
                str = p.bit + str;
                p = p.next;
            }
        }
        return str;
    }

    private static class Node {
        private int bit;
        private Node next;
        private Node(int bit, Node next) {
            this.bit = bit;
            this.next = next;
        }
    }

    private class BitListIterator implements Iterator {
        private Node current = null;
        private BitListIterator() {
            current = null;
        }
        public boolean hasNext() {
            return ((current == null && first != null) || 
                    (current != null && current.next != null));
        }
        public int next() {
            if (current == null) {
                current = first;
            } else {
                current = current.next;
            }
            if (current == null) {
                throw new NoSuchElementException();
            }
            return current.bit;
        }
        public void add(int bit) {
            if ((bit != ZERO) && (bit != ONE)) {
                throw new IllegalArgumentException(Integer.toString(bit));
            }
            if (current == null) {
                first = new Node(bit, first);
                current = first;
            } else {
                current.next = new Node(bit, current.next);
                current = current.next;
            }
        }
    }
}