public class Simulator {
    public static final int PLATE_NUM_LENGTH = 3;
    public static final int NUM_SECONDS_IN_1H = 3600;
    public static final int MAX_PARKING_DURATION = 8 * NUM_SECONDS_IN_1H;
    public static final int SIMULATION_DURATION = 24 * NUM_SECONDS_IN_1H;
    public static final TriangularDistribution departurePDF =
            new TriangularDistribution(0, MAX_PARKING_DURATION / 2, MAX_PARKING_DURATION);

    private Rational probabilityOfArrivalPerSec;
    private int clock;
    private int steps;
    private ParkingLot lot;
    private Queue<Spot> incomingQueue;
    private Queue<Spot> outgoingQueue;

    public Simulator(ParkingLot lot, int perHourArrivalRate, int steps) {
        if (lot == null) {
            throw new NullPointerException("Parking lot cannot be null!");
        }
        if (perHourArrivalRate < 0) {
            throw new IllegalArgumentException("Arrival rate cannot be negative!");
        }
        this.lot = lot;
        this.steps = steps;
        this.clock = 0;
        this.probabilityOfArrivalPerSec = new Rational(perHourArrivalRate, NUM_SECONDS_IN_1H);
        this.incomingQueue = new LinkedQueue<>();
        this.outgoingQueue = new LinkedQueue<>();
    }

    public void simulate() {
        while (clock < steps) {
            if (!outgoingQueue.isEmpty() && 
                RandomGenerator.eventOccurred(departurePDF.pdf(clock - outgoingQueue.peek().getTimestamp()))) {
                outgoingQueue.dequeue();
            }

            if (!incomingQueue.isEmpty() && lot.attemptParking(incomingQueue.peek().getCar(), clock)) {
                incomingQueue.dequeue();
            }

            if (RandomGenerator.eventOccurred(probabilityOfArrivalPerSec)) {
                incomingQueue.enqueue(new Spot(new Car(RandomGenerator.generateRandomString(PLATE_NUM_LENGTH)), clock));
            }

            clock++;
        }
    }

    public int getIncomingQueueSize() {
        return incomingQueue.size();
    }
}
