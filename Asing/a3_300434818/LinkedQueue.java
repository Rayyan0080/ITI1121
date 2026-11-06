public class LinkedQueue<D> implements Queue<D> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<D> front;
    private Elem<D> rear;
    private int size;  // New variable to track size

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(D newElement) {
        if (newElement == null) {
            throw new NullPointerException("No null object in queue!");
        }

        Elem<D> newElem = new Elem<>(newElement, null);
        if (isEmpty()) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
        size++;
    }

    public D dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Dequeue called on empty queue");
        }

        D returnedValue = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return returnedValue;
    }

    public D peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Peek called on empty queue");
        }
        return front.value;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder returnedValue = new StringBuilder("[");
        if (!isEmpty()) {
            Elem<D> cursor = front;
            returnedValue.append(cursor.value);
            while (cursor.next != null) {
                cursor = cursor.next;
                returnedValue.append(", ").append(cursor.value);
            }
        }
        returnedValue.append("]");
        return returnedValue.toString();
    }
}
