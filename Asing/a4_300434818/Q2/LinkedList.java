/**
 * A generic implementation of a doubly linked list
 * @param <E> the type of elements in this list
 */
public class LinkedList<E> implements List<E> {
    
    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;
        
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    /**
     * Constructor for LinkedList
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Returns an iterator over the elements in this list
     * @return an iterator over the elements in this list
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator(head, 0);
    }
    
    /**
     * Returns an iterator over the elements in this list, starting at the specified position in the list
     * @param nextIndex the index of the first element to be returned from the iterator 
     * @return an iterator over the elements in this list, starting at the specified position
     * @throws IndexOutOfBoundsException if the nextIndex is out of range
     */
    public Iterator<E> iterator(int nextIndex) {
        if (nextIndex < 0 || nextIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        
        // Find the node at the specified position
        Node<E> current = head;
        for (int i = 0; i < nextIndex && current != null; i++) {
            current = current.next;
        }
        
        return new LinkedListIterator(current, nextIndex);
    }
    
    /**
     * Returns an iterator over the elements in this list, starting at the same position as other
     * @param other the iterator to use as a reference point
     * @return an iterator over the elements in this list, starting at the same position as other
     */
    public Iterator<E> iterator(Iterator<E> other) {
        if (other instanceof LinkedListIterator) {
            LinkedListIterator otherIterator = (LinkedListIterator) other;
            return new LinkedListIterator(otherIterator.current, otherIterator.nextIndex);
        }
        return iterator();
    }
    
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private int nextIndex;
        
        public LinkedListIterator(Node<E> node, int index) {
            current = node;
            nextIndex = index;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public E next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            E result = current.value;
            current = current.next;
            nextIndex++;
            return result;
        }
        
        public int nextIndex() {
            return nextIndex;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Adds the specified element to the end of this list
     * @param element the element to add
     * @return true if the element was added, false otherwise
     */
    public boolean add(E element) {
        if (head == null) {
            head = new Node<E>(element, null, null);
            tail = head;
        } else {
            tail.next = new Node<E>(element, tail, null);
            tail = tail.next;
        }
        size++;
        return true;
    }
    
    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
}