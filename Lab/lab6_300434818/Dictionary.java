import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREMENT = 5;
    private Pair[] elems;
    private int count;

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public Integer get(String key) {
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    @Override
    public boolean contains(String key) {
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(String key, Integer value) {
        if (count == elems.length) {
            increaseCapacity();
        }
        elems[count++] = new Pair(key, value);
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                elems[i].setValue(value);
                return;
            }
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    @Override
    public Integer remove(String key) {
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                Integer value = elems[i].getValue();
                System.arraycopy(elems, i + 1, elems, i, count - i - 1);
                elems[--count] = null;
                return value;
            }
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    private void increaseCapacity() {
        Pair[] newElems = new Pair[elems.length + INCREMENT];
        System.arraycopy(elems, 0, newElems, 0, count);
        elems = newElems;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Dictionary: {elems = [");
        for (int i = count - 1; i >= 0; i--) {
            result.append(elems[i]);
            if (i > 0) {
                result.append(", ");
            }
        }
        result.append("]}");
        return result.toString();
    }
}
