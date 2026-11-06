public class Arithmetic extends AbstractSeries {

    private double sum = 0;
    private int step = 1;

    @Override
    public double next() {
        sum += step;
        step++;
        return sum;
    }
}
