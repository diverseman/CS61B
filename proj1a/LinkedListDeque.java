//这里的泛型复习一下，没想清楚

public class LinkedListDeque<T> {
    // 需要一个LinkedList 节点
     private class Node{
        private T  item;
        private Node previous;
        private Node next;
         Node(T i ,Node p,Node n){
             item=i;
             previous=p;
             next=n;
         }
         // sentinel节点准备的构造器
         Node ( Node p ,Node n){
             previous=p;
             next=n;

         }
    }
    // 初始化的话，应该有一个节点
    private Node sentinel;
    private   int  size;
     //生成一个空的Deque，此时size为0
     public LinkedListDeque(){
         //sentinel 最开始应该是自己指向自己，null应该也可以

         sentinel=new Node(null,null);
         sentinel.next=sentinel;
         sentinel.previous=sentinel;
         size =0;
    }


    public  void  addFirst(T item){
        Node temp=new Node(item,null,null);
        //共有操作
        sentinel.next=temp;
        temp.previous=sentinel;
        //只有sentinel
        if (size()==0){
            //sentinel的 前后都给第一个节点
            sentinel.next=temp;
            //第一节点的前后都给 sentinel
            temp.previous=sentinel;
        }
        //如果有好几个节点
        else {
            temp.next=sentinel.previous;
            sentinel.previous.previous=temp;
        }
         //节点需要加1
         size=size+1;
    }
    public void addLast(T item){
         Node temp=new Node(item,null,null  );

        //找到之前的最后一个节点
        Node preLast=sentinel.previous;
         //共有操作
        temp.next=sentinel;
        sentinel.previous=temp;


        //如果一个节点
        if (size()==0){
            //sentinel的 前后都给第一个节点
            sentinel.next=temp;
            //第一节点的前后都给 sentinel
            temp.previous=sentinel;
        }
        //如果好几个节点,用preLast
        else {
            preLast.next=temp;
            temp.previous=preLast;
        }

        size=size+1;

    }
    public boolean isEmpty(){

         if (size==0){
             return true;
         }
         return  false;

    }
    public int size(){
         return size;

    }
    public void printDeque(){
         Node temp=sentinel.next;
         while (temp!=sentinel){
             System.out.print(temp.item);
             temp=temp.next;
         }
    }
    public T removeFirst(){
         if (size()==0){
             return null;
         }
        Node temp=sentinel.next;
         //如果只有一个节点
         if (size==1){
             sentinel.next=sentinel;
             sentinel.previous=sentinel;

         }
         //如果有很多节点
         else {
             sentinel.next=temp.next;
             temp.next.previous=sentinel;
         }
        temp.next=null;
        temp.previous=null;
        size-=1;
        return temp.item;


    }
    public T  removeLast(){
        if (size==0){
            return null;
        }

        //如果有一个节点
        if (size()==1){
            Node temp=sentinel.next;
            sentinel.next=sentinel;
            sentinel.previous=sentinel;
            temp.previous=null;
            temp.next=null;
            size-=1;
            return temp.item;
        }
        //如果有很多节点
        else {
            Node temp=sentinel.previous;
            sentinel.previous=temp.previous;
            temp.previous.next=sentinel;
            temp.next=null;
            temp.previous=null;
            size-=1;

            return temp.item;
        }


    }
    public T get(int index){
         Node temp=sentinel.next;
         int i=0;
         if (size()==0) return sentinel.item;
         while (temp!=sentinel){
             if (i==index){
                 return temp.item;
             }
             temp=temp.next;
             i+=1;
         }
         return null;

    }
    //和 get 一样
    //加入一个helper函数就会好很多,思想是用另一个helper递归函数 让index 和起始点 两者不断逼近
    private T getRecursiveHelper(Node temp, int index) {
        if (index == 0) {
            return temp.item;
        }

        return getRecursiveHelper(temp.next, index - 1);

    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

}
