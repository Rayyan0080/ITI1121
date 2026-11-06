import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }
        /* Your code here */
        if (count == elems.length) {
            increaseCapacity();
        }
        elems[count++] = new Pair(key, value);
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
        Pair[] newElems = new Pair[elems.length + INCREMENT];
        System.arraycopy(elems, 0, newElems, 0, elems.length);
        elems = newElems;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        /* Your code here. */
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        /* Your code here. */
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        throw new NoSuchElementException("Key not found");
    }

    @Override
    public void replace(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }
        /* Your code here. */
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                elems[i].setValue(value);
                return;
            }
        }
        throw new NoSuchElementException("Key not found");
    }

    @Override
    public Integer remove(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        /* Your code here. */
        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                Integer value = elems[i].getValue();
                elems[i] = null;

                for (int j = i; j < count - 1; j++) {
                    elems[j] = elems[j + 1];
                }
                elems[--count] = null;
                return value;
            }
        }
        throw new NoSuchElementException("Key not found");
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}
