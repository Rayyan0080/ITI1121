import java.util.Random;

public class Customer {
    // Class variable
    private static final int MAX_NUM_ITEMS = 20; // Maximum number of items a customer can have
    
    // Instance variables
    private int arrivalTime;
    private int initialNumberOfItems;
    private int numberOfItems;
    
    // Constructor
    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        
        // Determine initial number of items when customer is created
        Random generator = new Random();
        this.initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1) + 1; // At least 1 item
        this.numberOfItems = this.initialNumberOfItems;
    }
    
    // Instance methods
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    public int getNumberOfItems() {
        return numberOfItems;
    }
    
    public int getNumberOfServedItems() {
        return initialNumberOfItems - numberOfItems;
    }
    
    public void serve() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
    }
}