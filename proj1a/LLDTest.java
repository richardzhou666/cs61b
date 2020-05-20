import org.junit.Test;
import static org.junit.Assert.*;

public class LLDTest {
    @org.junit.Test
    public void addTest() {
        // Initialize
        LinkedListDeque<Integer> A = new LinkedListDeque<>(1);
        A.addFirst(2);
        A.addLast(3);
        int expected = 2;
        int actual = A.removeFirst();
        int expected2 = 3;
        int actual2 = A.get(1);
        assertEquals(expected,actual);
        assertEquals(expected2, actual2);
    }
}
