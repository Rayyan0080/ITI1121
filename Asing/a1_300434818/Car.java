/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class Car {

    /**
     * Instance variable for storing the type of the car
     */
    private CarType type;

    /**
     * Instance variable for storing the car plate number
     */
    private String plateNum;

    /**
     * Constructor for Car
     *
     * @param type     is the type of the car
     * @param plateNum is the car plate number
     */
    public Car(CarType type, String plateNum) {
        if (type == null) {
            throw new IllegalArgumentException("Car type cannot be null.");
        }
        if (plateNum == null || plateNum.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate number cannot be null or empty.");
        }
        this.type = type;
        this.plateNum = plateNum.trim();
    }

    /**
     * @return the type of this car
     */
    public CarType getType() {
        return type;
    }

    /**
     * Sets the type of the car
     *
     * @param type is the car type
     */
    public void setType(CarType type) {
        if (type != null) {
            this.type = type;
        }
    }

    /**
     * @return the plate number
     */
    public String getPlateNum() {
        return plateNum;
    }

    /**
     * Sets the car plate number
     *
     * @param plateNum is the car plate number
     */
    public void setPlateNum(String plateNum) {
        if (plateNum != null && !plateNum.trim().isEmpty()) {
            this.plateNum = plateNum.trim();
        }
    }

    /**
     * Returns a string representation of the car
     */
    @Override
    public String toString() {
        return Util.getLabelByCarType(type) + '(' + plateNum + ')';
    }
}
