package synthesizer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        int actual = arb.peek();
        assertEquals(2, actual);
        assertEquals(3, arb.fillCount());
        arb.dequeue();
        assertEquals(2, arb.fillCount());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void overflowTest() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Ring buffer overflow");
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(1);
        arb.enqueue(2);
        arb.enqueue(2);
    }

    @Test
    public void underflowTest() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Ring buffer underflow");
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(1);
        arb.enqueue(2);
        arb.dequeue();
        arb.dequeue();
    }

    // Uncomment to test iterator (change to private first)
//    @Test
//    public void IteratorTest() {
//        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
//        Iterator<Integer> seer = arb.iterator();
//        arb.enqueue(1);
//        arb.enqueue(2);
//        arb.enqueue(3);
//        while (seer.hasNext()) {
//            System.out.print(seer.next() + " ");
//        }
//    }
//    /** Calls tests for ArrayRingBuffer. */
//    public static void main(String[] args) {
//        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
//    }
} 
