package examPre6;

public class examPre6 {
    public static void checkIfZero(int x) throws Exception {
        if (x == 0) {
            throw new Exception("x was zero!");
        }
        System.out.println(x); // PRINT STATEMENT
    }

    public static int mystery(int x) {
        int counter = 0;
        try {
            while (true) {
                x = x / 2;
                checkIfZero(x);
                counter += 1;
                System.out.println("counter is " + counter); // PRINT STATEMENT
            }
        } catch (Exception e) {
            return counter;
        }
    }

    public static void main(String[] args) {
        System.out.println("mystery of  is " + mystery(1));
        System.out.println("mystery of  is " + mystery(6));
    }

}

class AltList<Integer, String> {
     Integer item;
     AltList<String, Integer> next;

    AltList(Integer item, AltList<String, Integer> next) {
        this.item = item;
        this.next = next;
    }

    //用递归的方法去实现，很巧妙
    public  AltList<String,Integer> pairsSwapped(){
        AltList<String,Integer> res=new AltList<String, Integer>(next.item,new AltList<Integer, String>(item,null));
        if (next.next!=null){
            res.next.next=next.next.pairsSwapped();
        }
        return res;
    }





}
class  test{
    public static void main(String[] args) {
         AltList<Integer, String> list =
                 new AltList<Integer, String>(5,
                 new AltList<String, Integer>("cat",
                 new AltList<Integer, String>(10,
                 new AltList<String, Integer>("dog", null))));
         AltList<String,Integer> res=list.pairsSwapped();
        System.out.println(res.item);
        System.out.println(res.next.item);
    }
}




