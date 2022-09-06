import java.util.*;


class BiDividerMap<Integer,T>{
    private Map container;
    private PriorityQueue<Integer> keys ;
    private Map SecondContainer;
    public BiDividerMap(){
       container= new HashMap<Integer, T>();
       keys=new PriorityQueue();
       container= new HashMap<T, Integer>();
    }
    public void put(Integer k, T V){
        container.put(k,V);
        keys.add(k);
        container.put(V,k);

    }
    public T getByKey(Integer  k ){

        return  (T) container.get(k);
    }
    public Integer getByValue(T V){
        return (Integer) SecondContainer.get(V);
    }
    public List<Integer> numLessThan(int  k){
        List<Integer> temp=new ArrayList();
        if ((int)keys.peek()<k) {
            temp.add(keys.poll());

        }
        return temp;
    }


}

class MedianFinder{


}

class  Queue<T>{
    private Stack <T>stack;

    public Queue(){
       stack= new Stack<>();
    }
    public void push( T e ){
        stack.push(e);

    }
    public T pop(){
        Stack<T> s=new Stack<>();
        while (!stack.isEmpty()){
            s.push(stack.pop());

        }
        T temp = stack.pop();
        while (!s.isEmpty()){
            stack.push(s.pop());
        }
        return temp;
    }




}
