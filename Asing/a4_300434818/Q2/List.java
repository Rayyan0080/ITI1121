/**
 * Interface for a list
 * @param <E> the type of elements in this list
 */
public interface List<E> {
    
    /**
     * Returns an iterator over the elements in this list
     * @return an iterator over the elements in this list
     */
    public Iterator<E> iterator();
    
    /**
     * Returns an iterator over the elements in this list, starting at the specified position in the list
     * @param nextIndex the index of the first element to be returned from the iterator 
     * @return an iterator over the elements in this list, starting at the specified position
     * @throws IndexOutOfBoundsException if the nextIndex is out of range
     */
    public Iterator<E> iterator(int nextIndex);
    
    /**
     * Returns an iterator over the elements in this list, starting at the same position as other
     * @param other the iterator to use as a reference point
     * @return an iterator over the elements in this list, starting at the same position as other
     */
    public Iterator<E> iterator(Iterator<E> other);
    
    /**
     * Adds the specified element to the end of this list
     * @param element the element to add
     * @return true if the element was added, false otherwise
     */
    public boolean add(E element);
    
    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty();
}