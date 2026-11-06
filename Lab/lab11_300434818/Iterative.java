public class Iterative {
    public static BitList complement(BitList in) {
        if (in == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        BitList result = new BitList();
        Iterator iterator = in.iterator();
        while (iterator.hasNext()) {
            int bit = iterator.next();
            result.addFirst(bit == BitList.ZERO ? BitList.ONE : BitList.ZERO);
        }
        BitList reversed = new BitList();
        Iterator resultIterator = result.iterator();
        while (resultIterator.hasNext()) {
            reversed.addFirst(resultIterator.next());
        }
        return reversed;
    }

    public static BitList or(BitList a, BitList b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }
        Iterator aIter = a.iterator();
        Iterator bIter = b.iterator();
        if (!aIter.hasNext() || !bIter.hasNext()) {
            throw new IllegalArgumentException("Lists cannot be empty");
        }
        BitList result = new BitList();
        while (aIter.hasNext() && bIter.hasNext()) {
            int bitA = aIter.next();
            int bitB = bIter.next();
            result.addFirst((bitA == BitList.ONE || bitB == BitList.ONE) ? BitList.ONE : BitList.ZERO);
        }
        if (aIter.hasNext() || bIter.hasNext()) {
            throw new IllegalArgumentException("Lists must be of the same length");
        }
        BitList reversed = new BitList();
        Iterator resultIterator = result.iterator();
        while (resultIterator.hasNext()) {
            reversed.addFirst(resultIterator.next());
        }
        return reversed;
    }

    public static BitList and(BitList a, BitList b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }
        Iterator aIter = a.iterator();
        Iterator bIter = b.iterator();
        if (!aIter.hasNext() || !bIter.hasNext()) {
            throw new IllegalArgumentException("Lists cannot be empty");
        }
        BitList result = new BitList();
        while (aIter.hasNext() && bIter.hasNext()) {
            int bitA = aIter.next();
            int bitB = bIter.next();
            result.addFirst((bitA == BitList.ONE && bitB == BitList.ONE) ? BitList.ONE : BitList.ZERO);
        }
        if (aIter.hasNext() || bIter.hasNext()) {
            throw new IllegalArgumentException("Lists must be of the same length");
        }
        BitList reversed = new BitList();
        Iterator resultIterator = result.iterator();
        while (resultIterator.hasNext()) {
            reversed.addFirst(resultIterator.next());
        }
        return reversed;
    }

    public static BitList xor(BitList a, BitList b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }
        Iterator aIter = a.iterator();
        Iterator bIter = b.iterator();
        if (!aIter.hasNext() || !bIter.hasNext()) {
            throw new IllegalArgumentException("Lists cannot be empty");
        }
        BitList result = new BitList();
        while (aIter.hasNext() && bIter.hasNext()) {
            int bitA = aIter.next();
            int bitB = bIter.next();
            result.addFirst((bitA != bitB) ? BitList.ONE : BitList.ZERO);
        }
        if (aIter.hasNext() || bIter.hasNext()) {
            throw new IllegalArgumentException("Lists must be of the same length");
        }
        BitList reversed = new BitList();
        Iterator resultIterator = result.iterator();
        while (resultIterator.hasNext()) {
            reversed.addFirst(resultIterator.next());
        }
        return reversed;
    }
}