import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {

    // Constants for file structure
    private static final String SEPARATOR = ",";
    private static final String SECTIONER = "###";

    // Instance variables
    private int numRows;
    private int numSpotsPerRow;
    private CarType[][] lotDesign;
    private Car[][] occupancy;

    /**
     * Constructor for ParkingLot
     * 
     * @param strFilename The name of the input file containing parking lot details
     */
    public ParkingLot(String strFilename) throws Exception {
        if (strFilename == null) {
            throw new IllegalArgumentException("File name cannot be null.");
        }

        calculateLotDimensions(strFilename);  // First pass: determine dimensions
        lotDesign = new CarType[numRows][numSpotsPerRow];  // Initialize lot design
        occupancy = new Car[numRows][numSpotsPerRow];  // Initialize occupancy

        populateFromFile(strFilename);  // Second pass: populate lot data
    }

    /**
     * Attempts to park a car at a specific location
     */
    public void park(int i, int j, Car c) {
        if (canParkAt(i, j, c)) {
            occupancy[i][j] = c;
        }
    }

    /**
     * Removes a car from a parking spot
     */
    public Car remove(int i, int j) {
        if (i < 0 || i >= numRows || j < 0 || j >= numSpotsPerRow || occupancy[i][j] == null) {
            return null;
        }
        Car removedCar = occupancy[i][j];
        occupancy[i][j] = null;
        return removedCar;
    }

    /**
     * Checks if a car can be parked at a specific spot
     */
    public boolean canParkAt(int i, int j, Car c) {
        if (i < 0 || i >= numRows || j < 0 || j >= numSpotsPerRow) {
            return false;
        }
        if (lotDesign[i][j] == CarType.NA || occupancy[i][j] != null) {
            return false;
        }

        CarType spotType = lotDesign[i][j];
        CarType carType = c.getType();

        // Parking rules based on car type
        switch (carType) {
            case ELECTRIC:
                return true;
            case SMALL:
                return spotType == CarType.SMALL || spotType == CarType.REGULAR || spotType == CarType.LARGE;
            case REGULAR:
                return spotType == CarType.REGULAR || spotType == CarType.LARGE;
            case LARGE:
                return spotType == CarType.LARGE;
            default:
                return false;
        }
    }

    /**
     * @return The total capacity of the parking lot
     */
    public int getTotalCapacity() {
        int capacity = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSpotsPerRow; j++) {
                if (lotDesign[i][j] != CarType.NA) {
                    capacity++;
                }
            }
        }
        return capacity;
    }

    /**
     * @return The total number of occupied spots
     */
    public int getTotalOccupancy() {
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSpotsPerRow; j++) {
                if (occupancy[i][j] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * First pass - Determines the dimensions of the parking lot
     */
    private void calculateLotDimensions(String strFilename) throws Exception {
        Scanner scanner = new Scanner(new File(strFilename));
        int rows = 0, cols = 0;

        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue; 
            if (line.equals(SECTIONER)) break; 

            rows++;
            cols = Math.max(cols, line.split(SEPARATOR).length);
        }

        scanner.close();
        numRows = rows;
        numSpotsPerRow = cols;
    }

    /**
     * Second pass - Populates the parking lot design and occupancy data
     */
    private void populateFromFile(String strFilename) throws Exception {
        Scanner scanner = new Scanner(new File(strFilename));

        // Populate parking lot design
        for (int i = 0; i < numRows; i++) {
            String line;
            do {
                line = scanner.nextLine().trim();
            } while (line.isEmpty()); // Skip empty lines

            String[] row = line.split(SEPARATOR);
            for (int j = 0; j < numSpotsPerRow; j++) {
                lotDesign[i][j] = (j < row.length) ? Util.getCarTypeByLabel(row[j].trim()) : CarType.NA;
            }
        }

        // Skip section separator
        while (scanner.hasNext()) {
            if (scanner.nextLine().trim().equals(SECTIONER)) break;
        }

        // Populate occupancy
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] data = line.split(SEPARATOR);
            if (data.length != 4) continue;

            try {
                int row = Integer.parseInt(data[0].trim()); 
                int col = Integer.parseInt(data[1].trim());
                CarType carType = Util.getCarTypeByLabel(data[2].trim());
                String plateNum = data[3].trim();

                if (canParkAt(row, col, new Car(carType, plateNum))) {
                    occupancy[row][col] = new Car(carType, plateNum);
                } else {
                    System.out.println("Car " + carType + "(" + plateNum + ") cannot be parked at (" + row + "," + col + ")");
                }
            } catch (Exception e) {
                System.out.println("Error processing entry: " + String.join(",", data));
            }
        }

        scanner.close();
    }

    /**
     * Converts ParkingLot to a readable string
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("==== Lot Design ====\n");
        for (CarType[] row : lotDesign) {
            for (CarType spot : row) {
                buffer.append(Util.getLabelByCarType(spot)).append(", ");
            }
            buffer.setLength(buffer.length() - 2); // Remove trailing comma
            buffer.append("\n");
        }

        buffer.append("\n==== Parking Occupancy ====\n");
        for (int i = 0; i < occupancy.length; i++) {
            for (int j = 0; j < numSpotsPerRow; j++) {
                buffer.append("(").append(i).append(", ").append(j).append("): ");
                buffer.append((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied").append("\n");
            }
        }
        return buffer.toString();
    }

    /**
     * Main method to run the ParkingLot program
     */
    public static void main(String[] args) throws Exception {
        StudentInfo.display();
        System.out.print("Please enter the name of the file to process: ");
        Scanner scanner = new Scanner(System.in);
        String strFilename = scanner.nextLine().trim();
        
        ParkingLot lot = new ParkingLot(strFilename);
        System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());
        System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());
        System.out.println(lot.toString());

        scanner.close();
    }
}
