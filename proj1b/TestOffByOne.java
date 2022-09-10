import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void TestEqualChars(){
        assertEquals(offByOne.equalChars('1','2'),false);
        assertEquals(offByOne.equalChars('1','1'),true);
    }


}
