import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
    private int numRows;
    private int numSpotsPerRow;
    private CarType[][] lotDesign;
    private Spot[][] occupancy;

    public ParkingLot(String strFilename) throws Exception {
        calculateLotDimensions(strFilename);
        populateDesignFromFile(strFilename);
        occupancy = new Spot[numRows][numSpotsPerRow];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumSpotsPerRow() {
        return numSpotsPerRow;
    }

    public void park(int i, int j, Car c, int timestamp) {
        if (canParkAt(i, j, c)) {
            occupancy[i][j] = new Spot(c, timestamp);
            System.out.printf("%s ENTERED at timestep %d; occupancy is at %d%n",
                    c, timestamp, getTotalOccupancy());
        }
    }

    public Spot remove(int i, int j) {
        if (i >= 0 && i < numRows && j >= 0 && j < numSpotsPerRow && occupancy[i][j] != null) {
            Spot removedSpot = occupancy[i][j];
            occupancy[i][j] = null;
            System.out.printf("%s EXITED at timestep %d; occupancy is at %d%n",
                    removedSpot.getCar(), removedSpot.getTimestamp(), getTotalOccupancy());
            return removedSpot;
        }
        return null;
    }

    public Spot getSpotAt(int i, int j) {
        if (i >= 0 && i < numRows && j >= 0 && j < numSpotsPerRow) {
            return occupancy[i][j];
        }
        return null;
    }

    public boolean canParkAt(int i, int j, Car c) {
        if (lotDesign[i][j] == CarType.NA || occupancy[i][j] != null) {
            return false;
        }
        CarType spotType = lotDesign[i][j];
        CarType carType = c.getType();
        return (spotType == carType) ||
                (spotType == CarType.REGULAR && carType != CarType.NA) ||
                (spotType == CarType.LARGE && (carType == CarType.LARGE || carType == CarType.REGULAR));
    }

    public boolean attemptParking(Car c, int timestamp) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSpotsPerRow; j++) {
                if (canParkAt(i, j, c)) {
                    park(i, j, c, timestamp);
                    return true;
                }
            }
        }
        return false;
    }

    public int getTotalCapacity() {
        int capacity = 0;
        for (CarType[] row : lotDesign) {
            for (CarType spot : row) {
                if (spot != CarType.NA) {
                    capacity++;
                }
            }
        }
        return capacity;
    }

    public int getTotalOccupancy() {
        int count = 0;
        for (Spot[] row : occupancy) {
            for (Spot spot : row) {
                if (spot != null) {
                    count++;
                }
            }
        }
        return count;
    }

    private void calculateLotDimensions(String strFilename) throws Exception {
        Scanner scanner = new Scanner(new File(strFilename));
        numRows = 0;
        while (scanner.hasNextLine()) {
            numRows++;
            if (numSpotsPerRow == 0) {
                numSpotsPerRow = scanner.nextLine().split(",").length;
            } else {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void populateDesignFromFile(String strFilename) throws Exception {
        Scanner scanner = new Scanner(new File(strFilename));
        lotDesign = new CarType[numRows][numSpotsPerRow];
        int row = 0;
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(",");
            for (int col = 0; col < tokens.length; col++) {
                lotDesign[row][col] = Util.getCarTypeByLabel(tokens[col].trim());
            }
            row++;
        }
        scanner.close();
    }
}
