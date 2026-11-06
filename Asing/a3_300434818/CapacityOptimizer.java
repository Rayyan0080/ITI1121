public class CapacityOptimizer {
    private static final int NUM_RUNS = 10;
    private static final double THRESHOLD = 5.0d;

    public static int getOptimalNumberOfSpots(int hourlyRate) {
        int lotSize = 1;

        while (true) {
            System.out.println("\n==== Setting lot capacity to: " + lotSize + "====");
            double totalQueueLength = 0;

            for (int i = 1; i <= NUM_RUNS; i++) {
                ParkingLot lot = new ParkingLot(lotSize);
                Simulator simulator = new Simulator(lot, hourlyRate, Simulator.SIMULATION_DURATION);

                long startTime = System.currentTimeMillis();
                simulator.simulate();
                long endTime = System.currentTimeMillis();

                int queueLength = simulator.getIncomingQueueSize();
                totalQueueLength += queueLength;

                System.out.println("Simulation run " + i + " (" + (endTime - startTime) + "ms); " +
                        "Queue length at the end of simulation run: " + queueLength);
            }

            double averageQueueSize = totalQueueLength / NUM_RUNS;
            if (averageQueueSize <= THRESHOLD) {
                return lotSize;
            }
            lotSize++;
        }
    }

    public static void main(String args[]) {
        StudentInfo.display();

        long mainStart = System.currentTimeMillis();

        if (args.length < 1) {
            System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
            System.out.println("Example: java CapacityOptimizer 11");
            return;
        }

        if (!args[0].matches("\\d+")) {
            System.out.println("The hourly rate of arrival should be a positive integer!");
            return;
        }

        int hourlyRate = Integer.parseInt(args[0]);

        int lotSize = getOptimalNumberOfSpots(hourlyRate);

        System.out.println("\nSIMULATION IS COMPLETE!");
        System.out.println("The smallest number of parking spots required: " + lotSize);

        long mainEnd = System.currentTimeMillis();
        System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");
    }
}
