package hw2;
import java.util.ArrayList;
import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    private final double[] x; // fraction of open sites
    private double sum;
    private final int T;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N or T should not be less than 0!");
        }
        x = new double[T];
        sum = 0;
        this.T = T;
        ArrayList<Percolation> pList = new ArrayList<>(T);
        for (int i = 0; i < T; i++) {
            Percolation a = pf.make(N);
            StdRandom.setSeed(i);
            while (!a.percolates()) {
                int randID = StdRandom.uniform(N * N - 1);
                int row = randID / N;
                int col = randID % N;
                if (!a.isOpen(row, col)) {
                    a.open(row, col);
                }
            }
            x[i] = (double) a.numberOfOpenSites() / (N * N);
            sum += (double) a.numberOfOpenSites() / (N * N);
            pList.add(a);
        }
    }

    public double mean() {
        return sum / T;
    }

    public double stddev() {
        double sum2 = 0;
        for (double item: x) {
            sum2 += (item - mean()) * (item - mean());
        }
        return Math.sqrt(sum2 / (T - 1));
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
