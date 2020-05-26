package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation extends WeightedQuickUnionUF{
    private final boolean[] x;
    private final int N;
    private int open_count;

    // Constructor: Create empty N x N array
    public Percolation(int N) {
        super(N * N);
        this.N = N;
        x = new boolean[N * N];
        open_count = 0;
    }

    // Convert two-d array into one-d
    private int xytox(int row, int col) {
        return N * row + col;
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        int id = xytox(row, col);
        int[] neighbor = {id - 1, id + 1, id - N, id + N};
        for (int item: neighbor)
            if (item < N * N && item > 0) {
                if (isOpen(item)) {
                    union(item, id);
                }
            }
        x[id] = true;
        open_count += 1;
    }

    boolean isOpen(int id) {
        return x[id];
    }

    public boolean isOpen(int row, int col) {
        int id = xytox(row, col);
        return x[id];
    }

    public int numberOfOpenSites() {
        return open_count;
    }

    public boolean isFull(int row, int col) {
        for (int i = 0; i < N; i ++) {
            if (isOpen(row, col)) {
                if (connected(xytox(row, col), i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean percolates() {
        for (int i = 0; i < N; i ++) {
            if (isFull(N - 1, i)) {
                return true;
            }
        }
        return false;
    }
}
