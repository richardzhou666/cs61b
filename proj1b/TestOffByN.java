import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN ob5 = new OffByN(5);
    static OffByN ob3 = new OffByN(3);

    @Test
    public void ob5Test() {
        assertTrue(ob5.equalChars('a', 'f'));
        assertTrue(ob5.equalChars('f', 'a'));
        assertTrue(ob5.equalChars('f', 'h'));
        assertFalse(ob5.equalChars('a', 'B'));
        assertFalse(ob5.equalChars('a', ' '));
    }

    @Test
    public void ob3Test() {
        assertTrue(ob3.equalChars('a', 'c'));
        assertTrue(ob3.equalChars('c', 'a'));
        assertTrue(ob3.equalChars('f', 'h'));
        assertFalse(ob3.equalChars('A', 'B'));
        assertFalse(ob3.equalChars('a', ' '));
    }
}
