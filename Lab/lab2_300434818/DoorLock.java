public class DoorLock {
    // Constants
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor
    public DoorLock(Combination combination) {
        this.combination = combination;
        this.open = false;          // Starts closed
        this.activated = true;      // Starts activated
        this.numberOfAttempts = 0;  // No failed attempts yet
    }

    // Access methods
    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Attempt to open the door
    public boolean open(Combination combination) {
        if (!activated) {
            return false; // Can't open a deactivated lock
        }

        if (this.combination.equals(combination)) {
            open = true;             // Unlock the door
            numberOfAttempts = 0;    // Reset failed attempts
            return true;
        } else {
            numberOfAttempts++; // Increment failed attempts
            if (numberOfAttempts >= MAX_NUMBER_OF_ATTEMPTS) {
                activated = false;   // Deactivate the lock
            }
            return false;
        }
    }

    // Activate the lock
    public void activate(Combination combination) {
        if (this.combination.equals(combination)) {
            activated = true;         // Reactivate the lock
            numberOfAttempts = 0;     // Reset failed attempts
        }
    }
}
