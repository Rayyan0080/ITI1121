public interface Map< K, V> {

    /* Make the necessary abstract method definitions */

    /**
     * Returns the rightmost value associated with the specified key.
     *
     * @param key the key whose associated value is to be returned
     * @return the rightmost value associated with the specified key, or null if there is no association for the key
     */
    V get(K key);

    /**
     * Returns true if there is an association for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return true if there is an association for the specified key, false otherwise
     */
    boolean contains(K key);

    /**
     * Creates a new key-value association.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    void put(K key, V value);

    /**
     * Replaces the value of the rightmost occurrence of the association for the specified key.
     *
     * @param key the key whose associated value is to be replaced
     * @param value the value to be associated with the specified key
     */
    void replace(K key, V value);

    /**
     * Removes the rightmost occurrence of the specified key and returns the value that was associated with this key.
     *
     * @param key the key whose association is to be removed from the map
     * @return the value that was associated with the specified key, or null if there was no association for the key
     */
    V remove(K key);

}
