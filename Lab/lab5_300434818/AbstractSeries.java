public abstract class AbstractSeries implements Series {

    public double[] take(int count) {
        double[] results = new double[count];
        for (int i = 0; i < count; i++) {
            results[i] = next();
        }
        return results;
    }
}
