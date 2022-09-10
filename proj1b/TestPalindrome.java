import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public  void  testisPalindrome(){
        assertEquals(palindrome.isPalindrome("cat"),false);
        assertEquals(palindrome.isPalindrome("racecar"),true);
        assertEquals(palindrome.isPalindrome("raar"),true);
        assertEquals(palindrome.isPalindrome("1"),true);
        assertEquals(palindrome.isPalindrome(""),true);
        assertEquals(palindrome.isPalindrome("11",new OffByOne()),true);
        assertEquals(palindrome.isPalindrome("131",new OffByOne()),true);
        assertEquals(palindrome.isPalindrome("ABCCBA",new OffByOne()),true);
        assertEquals(palindrome.isPalindrome("",new OffByOne()),true);
        assertEquals(palindrome.isPalindrome("1",new OffByOne()),true);
    }
}
