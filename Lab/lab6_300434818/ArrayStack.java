public class ArrayStack<E> implements Stack<E> {

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private int capacity;  // Size of the array

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return elems[top - 1];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        E element = elems[--top];
        elems[top] = null; // Clean up memory
        return element;
    }

    @Override
    public void push(E element) {
        if (top == elems.length) {
            throw new IllegalStateException("Stack is full.");
        }
        elems[top++] = element;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            elems[i] = null;
        }
        top = 0;
    }

    public int getCapacity() {
        return elems.length;
    }
}
