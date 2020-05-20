import org.junit.Test;
import static org.junit.Assert.*;

public class ADTest {
    @Test
    public void addTest(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        int expected = 2;
        int actual = A.get(1);
        assertEquals(expected,actual);

        ArrayDeque<String> B = new ArrayDeque<>();
        B.addFirst("a");
        B.addLast("b");
        B.addLast("c");
        B.removeFirst();
        String expected2= "c";
        String actual2 = B.get(1);
        assertEquals(expected2,actual2);
    }

    @Test
    public void removeTest(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        int expected = 1;
        int actual = A.removeFirst();
        assertEquals(expected,actual);
    }

    @Test
    public void resizeTest(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        A.resize(100);
        int expected = 100;
        int actual = A.getLength();
        assertEquals(expected,actual);
    }

    @Test
    public void truncateTest(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        A.resize(100);
        A.truncate();
        int expected = 8;
        int actual = A.getLength();
        assertEquals(expected,actual);
        A.addLast(3);
        A.addLast(4);
        A.resize(1000);
        int expected2 = 1000;
        int actual2 = A.getLength();
        assertEquals(expected2, actual2);
        A.truncate();
        int expected3 = 16;
        int actual3 = A.getLength();
        assertEquals(expected3,actual3);
    }

    @Test
    public void getTest(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        assertNull(A.get(4));
    }
}
