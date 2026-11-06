/**
 * A generic implementation of a singly linked list
 * @param <E> the type of elements in this list
 */
public class SinglyLinkedList<E> implements List<E>, java.lang.Iterable<E> {

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
     * Returns an iterator over the elements in this list
     * @return an iterator over the elements in this list
     */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    // Modified to implement java.util.Iterator<E> instead of custom Iterator<E>
    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current;

        public LinkedListIterator() {
            current = head;
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
            return result;
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
     * Removes all of the elements from this list
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
} 
