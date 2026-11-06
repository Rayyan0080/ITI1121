public class DynamicArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int top;
    private static final int DEFAULT_INC = 25;

    @SuppressWarnings("unchecked")
    public DynamicArrayStack(int capacity) {
        int initialCapacity = Math.max(capacity, DEFAULT_INC);
        elems = (E[]) new Object[initialCapacity];
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
        elems[top] = null;  // Clean up memory

        // Shrink array if extra capacity exists
        if (elems.length > DEFAULT_INC && top <= elems.length - DEFAULT_INC) {
            resize(elems.length - DEFAULT_INC);
        }
        return element;
    }

    @Override
    public void push(E element) {
        if (top == elems.length) {
            resize(elems.length + DEFAULT_INC);
        }
        elems[top++] = element;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            elems[i] = null;
        }
        top = 0;
        resize(DEFAULT_INC);
    }

    private void resize(int newCapacity) {
        @SuppressWarnings("unchecked")
        E[] newElems = (E[]) new Object[newCapacity];
        System.arraycopy(elems, 0, newElems, 0, top);
        elems = newElems;
    }

    public int getCapacity() {
        return elems.length;
    }
}
