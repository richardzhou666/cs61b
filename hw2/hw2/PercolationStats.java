package hw2;
import java.util.Random;

public class PercolationStats {
    private final int[] x;
    private int sum;
    private final int T;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        x = new int[N * N];
        sum = 0;
        this.T = T;
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N or T should not be less than 0!");
        }
        Percolation a = pf.make(N);
        for (int i = 0; i < T; i ++) {
            while (!a.percolates()) {
                Random rand = new Random();
                int randID = rand.nextInt(N * N);
                if (!a.isOpen(randID)) {
                    int row = randID / 5;
                    int col = randID % 5;
                    a.open(row, col);
                }
            }
            x[i] = a.numberOfOpenSites();
            sum += a.numberOfOpenSites();
        }
    }

    public double mean() {
        return (double) sum / T;
    }

    public double stddev() {
        int sum2 = 0;
        for (int item: x) {
            sum += (item - mean()) * (item - mean());
        }
        return  (double) sum / (T - 1);
    }

    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }
}
