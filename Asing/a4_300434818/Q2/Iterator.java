/**
 * Interface for an iterator
 * @param <E> the type of elements returned by this iterator
 */
public interface Iterator<E> {
    
    /**
     * Returns true if the iteration has more elements
     * @return true if the iteration has more elements
     */
    public boolean hasNext();
    
    /**
     * Returns the next element in the iteration
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    public E next();
    
    /**
     * Returns the index of the element that would be returned by a subsequent call to next()
     * @return the index of the element that would be returned by a subsequent call to next()
     */
    public int nextIndex();
    
    /**
     * Removes from the underlying collection the last element returned by this iterator
     * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
     * @throws IllegalStateException if the next method has not yet been called
     */
    public void remove();
}