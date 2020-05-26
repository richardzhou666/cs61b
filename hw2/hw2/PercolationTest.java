package hw2;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {
    @Test
    public void sanityTest1() {
        Percolation a = new Percolation(5);
        assertFalse(a.isOpen(0, 0));
        assertFalse(a.isFull(0, 0));
    }

    @Test
    public void sanityTest2() {
        Percolation a = new Percolation(5);
        a.open(1, 3);
        assertTrue(a.isOpen(1, 3));
        a.open(0, 3);
        assertTrue(a.isOpen(0, 3));
        assertTrue(a.isFull(0, 3));
        assertTrue(a.isFull(1, 3));
        a.open(0, 0);
        assertTrue(a.isFull(0, 0));
        a.open(2, 0);
        a.open(1, 0);
        assertTrue(a.isOpen(1, 0));
        assertTrue(a.isFull(1, 0));
    }
}
