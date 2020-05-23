package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ABQtest {
    @Test
    public void test() {
        AbstractBoundedQueue<Integer> b2 = new ArrayRingBuffer<>(100);
        assertEquals(100, b2.capacity());
    }
}
