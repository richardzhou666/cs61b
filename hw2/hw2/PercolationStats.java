package hw2;
import java.util.Random;
import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    private final int[] x;
    private int sum;
    private final int T;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        x = new int[T];
        sum = 0;
        this.T = T;
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N or T should not be less than 0!");
        }
        Percolation a = pf.make(N);
        for (int i = 0; i < T; i ++) {
            while (!a.percolates()) {
                int randID = StdRandom.uniform(N * N - 1);
                if (!a.isOpen(randID)) {
                    int row = randID / N;
                    int col = randID % N;
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

    public static void main(String[] args) {
        PercolationFactory b = new PercolationFactory();
        PercolationStats a = new PercolationStats(3, 8000, b);
        System.out.println(a.mean());
        System.out.println(a.stddev());
        System.out.println(a.confidenceHigh());
    }
}
