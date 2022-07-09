
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class exampre3Test {
    @Test
      public  void  testFlatten(){
        int c[][]={{1, 2, 3}, {}, {7, 8}};
        int [] a =new Flatten().flatten(c);
        int b[]={1, 2, 3, 7, 8};
        assertArrayEquals(a,b);
    }




}
