import org.junit.Assert;
import org.junit.Test;

import java.security.cert.TrustAnchor;

class ArrayDequeTest {
     @Test
     public  static  void test(){
         ArrayDeque<String> sample=new ArrayDeque<>();
         Assert.assertEquals(true,sample.isEmpty());
         sample.addFirst("1");
         Assert.assertEquals(1,sample.size());
         sample.addFirst("2");
         sample.addFirst("3");
         Assert.assertEquals(3,sample.size());
         for (int i =0; i<9;i++){
             sample.addFirst(String.valueOf((i+4)));
         }
         Assert.assertEquals(12,sample.size());
         for (int i =0; i<9;i++){
             sample.removeFirst();
         }
         Assert.assertEquals(3,sample.size());

         System.out.println("this is the size:"+sample.size());
         System.out.println("this is the content:");
         sample.printDeque();
     }

    public static void main(String[] args) {
        test();
    }

}

class testAnother{
    @Test
    public static void test2(){
        ArrayDeque<String> q=new ArrayDeque<>();
        for (int i =0; i<32;i++) {
            q.addFirst(String.valueOf(i));
        }
        String s= q.removeLast();
        System.out.println(s);
        ArrayDeque<Integer> q1=new ArrayDeque<>();
        q1.addFirst(1);
        System.out.println("this is the q1`s size:"+q1.size());

    }

    public static void main(String[] args) {
        test2();
    }

}
