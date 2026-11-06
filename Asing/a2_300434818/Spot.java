/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Spot {
    private Car car;
    private int timestamp;

    public Spot(Car car, int timestamp) {
        this.car = car;
        this.timestamp = timestamp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return car + ", timestamp: " + timestamp;
    }
}
