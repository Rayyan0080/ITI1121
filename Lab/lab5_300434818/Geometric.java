public class Geometric extends AbstractSeries {

    private double sum = 0;
    private int power = 0;

    @Override
    public double next() {
        sum += Math.pow(0.5, power);
        power++;
        return sum;
    }
}
