import org.junit.Test;
import static org.junit.Assert.*;

public class LLDTest {
    @Test
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

    @Test
    public void removeLastTest() {
        LinkedListDeque<Integer> A = new LinkedListDeque<>(1);
        A.isEmpty();
        A.addFirst(1);
        A.addFirst(2);
        A.isEmpty();
        A.removeLast();
        A.removeLast();
        A.addFirst(6);
        A.addLast(3);
        A.removeFirst();
        int expected = 3;
        int actual = A.removeLast();
        assertEquals(expected, actual);
    }

    @Test
    public void GetTest() {
        LinkedListDeque<Integer> A = new LinkedListDeque<>(1);
        A.addLast(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addFirst(5);
        A.addFirst(6);
        A.addFirst(7);
        A.addFirst(8);
        A.addFirst(9);
        A.addFirst(10);
        A.removeFirst();
        A.removeFirst();
        A.removeLast();
        int expected = 3;
        int actual = A.get(5);
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstTest(){
        LinkedListDeque<Integer> A = new LinkedListDeque<>();
        A.addLast(0);
        int expected = 0;
        int actual = A.removeFirst();
        A.addLast(2);
        A.addLast(2);
        A.addLast(2);
        A.addLast(2);
        A.addLast(2);
        A.addLast(2);
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        int expected2 = 2;
        int actual2 = A.removeFirst();
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }
}
