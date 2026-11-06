public class ParkingLot {
    private List<Spot> occupancy;
    private int capacity;

    public ParkingLot(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }
        this.capacity = capacity;
        this.occupancy = new SinglyLinkedList<>();
    }

    public void park(Car c, int timestamp) {
        if (c == null) {
            throw new NullPointerException("Cannot park a null car!");
        }
        if (occupancy.size() >= capacity) {
            throw new IllegalStateException("Parking lot is full!");
        }
        occupancy.add(new Spot(c, timestamp));
    }

    public Spot remove(int i) {
        if (i < 0 || i >= occupancy.size()) {
            throw new IndexOutOfBoundsException("Invalid parking spot index!");
        }
        return occupancy.remove(i);
    }

    public boolean attemptParking(Car c, int timestamp) {
        if (occupancy.size() < capacity) {
            park(c, timestamp);
            return true;
        }
        return false;
    }

    public int getOccupancy() {
        return occupancy.size();
    }

    public String toString() {
        return "Total capacity: " + this.capacity + "\n" +
                "Total occupancy: " + this.occupancy.size() + "\n" +
                "Cars parked in the lot: " + this.occupancy;
    }
}
