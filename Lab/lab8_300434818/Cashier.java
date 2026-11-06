public class Cashier {
    // Instance variables
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;
    
    // Constructor
    public Cashier() {
        this.queue = new ArrayQueue<Customer>();
        this.currentCustomer = null;
        this.totalCustomerWaitTime = 0;
        this.customersServed = 0;
        this.totalItemsServed = 0;
    }
    
    // Add a customer to the queue
    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }
    
    // Return the number of customers in the queue
    public int getQueueSize() {
        return queue.size();
    }
    
    // Serve customers at the current time
    public void serveCustomers(int currentTime) {
        // If no current customer, get the next one from the queue
        if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            // Calculate and tally customer wait time
            totalCustomerWaitTime += (currentTime - currentCustomer.getArrivalTime());
        }
        
        // If there is a current customer, serve them
        if (currentCustomer != null) {
            // Serve one item
            currentCustomer.serve();
            
            // If customer has no more items, they are done
            if (currentCustomer.getNumberOfItems() == 0) {
                // Add to total items served
                totalItemsServed += currentCustomer.getNumberOfServedItems();
                // Increment customers served
                customersServed++;
                // Customer is done, set to null
                currentCustomer = null;
            }
        }
    }
    
    // Get total wait time for all customers
    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }
    
    // Get total number of items served
    public int getTotalItemsServed() {
        return totalItemsServed;
    }
    
    // Get total number of customers served
    public int getTotalCustomersServed() {
        return customersServed;
    }
    
    // Return a string representation of the cashier's statistics
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("The total number of customers served is ").append(customersServed).append("\n");
        
        // Calculate average items per customer
        int avgItems = 0;
        if (customersServed > 0) {
            avgItems = totalItemsServed / customersServed;
        }
        result.append("The average number of items per customer was ").append(avgItems).append("\n");
        
        // Calculate average wait time
        int avgWaitTime = 0;
        if (customersServed > 0) {
            avgWaitTime = totalCustomerWaitTime / customersServed;
        }
        result.append("The average waiting time (in seconds) was ").append(avgWaitTime);
        
        return result.toString();
    }
}