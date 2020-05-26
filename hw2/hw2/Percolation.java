package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[] x;
    private final int N;
    private int openCount;
    private final WeightedQuickUnionUF xy;

    // Constructor: Create empty N x N array
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N should be positive!");
        }
        this.N = N;
        x = new boolean[N * N];
        xy = new WeightedQuickUnionUF(N * N);
        openCount = 0;
    }

    // Convert two-d array into one-d
    private int xytox(int row, int col) {
        return N * row + col;
    }

    private boolean unionChecker(int i, int j) {
        if (i % N == 0 && i - j == 1) {
            return false;
        } else {
            return i % N != N - 1 || j - i != 1;
        }
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        int id = xytox(row, col);
        int[] neighbor = {id - 1, id + 1, id - N, id + N};
        for (int item: neighbor) {
            if (item < N * N && item > 0) {
                if (isOpen(item) && unionChecker(id, item)) {
                    xy.union(id, item);
                }
            }
        }
        x[id] = true;
        openCount += 1;
    }

    private boolean isOpen(int id) {
        return x[id];
    }

    public boolean isOpen(int row, int col) {
        int id = xytox(row, col);
        return x[id];
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean isFull(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (isOpen(row, col)) {
                if (xy.connected(xytox(row, col), i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean percolates() {
        for (int i = 0; i < N; i++) {
            if (isFull(N - 1, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) { }
}
