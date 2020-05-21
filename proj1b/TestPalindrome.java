import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator obo = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }// Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("level"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("deleveled"));
        assertFalse(palindrome.isPalindrome("richard"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome(" "));
        assertFalse(palindrome.isPalindrome("amy"));
        assertFalse(palindrome.isPalindrome("asdfoilkhasdflkas"));
    }
    @Test
    public void newOffByOneTest() {
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("amy", obo));
        assertFalse(palindrome.isPalindrome("123", obo));
        assertFalse(palindrome.isPalindrome("*^#%^#$%", obo));
    }
}
