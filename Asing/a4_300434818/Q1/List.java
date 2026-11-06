/**
 * Interface for a list
 * @param <E> the type of elements in this list
 */
public interface List<E> {
    
    /**
     * Adds the specified element to the end of this list
     * @param element the element to add
     * @return true if the element was added, false otherwise
     */
    public boolean add(E element);
    
    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size();
    
    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty();
    
    /**
     * Removes all of the elements from this list
     */
    public void clear();
    
    /**
     * Returns the element at the specified position in this list
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index);
}