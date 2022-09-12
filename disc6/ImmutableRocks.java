import javax.print.attribute.standard.NumberUp;

class BadIntegerStack {
    public class Node {
        private Integer value;
        private Node prev;

        public Node(Integer v, Node p) {
            value = v;
            prev = p;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        if (top==null) return null;
        Integer ans = top.value;
        top = top.prev;
        return ans;
    }

    public Integer peek() {
        return top.value;
    }


}
public class ImmutableRocks {
    public static void main(String[] args) {

        try {
            BadIntegerStack stack = new BadIntegerStack();
            stack.pop();
        }
        catch (NullPointerException e ) {
            System.out.println("Success");
        }


    }

}

class another{
    public static void main(String[] args) {
        BadIntegerStack stack=new BadIntegerStack();
        stack.push(1);
        //stack.top.prev=stack.top;
        while (!stack.isEmpty()){
            stack.pop();
            System.out.println("there is always a pointer point to 1");
        }

    }
}
