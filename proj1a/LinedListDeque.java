//这里的泛型复习一下，没想清楚

public class LinkedListDeque<T> {
    // 需要一个LinkedList 节点
     private class Node{


         // 还得想一想,两个变量得是私有的
        private int  item;
        private Node previous;
        private Node next;
         Node(int i ,Node p,Node n){
             item=i;
             previous=p;
             next=n;
         }
    }
    // 初始化的话，应该有一个节点
    private Node sentinel;
     int size;
     //生成一个空的Deque，此时size为0
     public LinkedListDeque(){
         //sentinel 最开始应该是自己指向自己，null应该也可以
         sentinel=new Node(0, null,null );
         size=0;
    }


    public  void  addFirst(T item){


         size=size+1;


    }
    public void addLast(T item){

    }
    public boolean isEmpty(){

    }
    public int size(){

    }
    public void printDeque(){

    }
    public T removeFirst(){

    }
    public T  removeLast(){

    }
    public T get(int index){

    }

    //和 get 一样
    public T getRecursive(int index){

    }

}
