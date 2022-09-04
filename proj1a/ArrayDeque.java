

/*
!!! a.length 是这个数声明时 的框框的长度， int a[]=new int[100]; a.length=100
所以这里的length和size 实际意义搞混了，需要重写

更改思路： 增加一个resizing，这个可以是O（n）的复杂度
resize(size*REFACTOR)
空间复杂度：usage ratio： SIZE/array.length
 halve the size of the array when R falls to less than 0.25.
*/
public class ArrayDeque <T>{
    //实际大小
     private static int size;
     private T a[];
    //容量
    private int capacity;
    private int addFirst;
    private int addLast;
    public ArrayDeque(){
        size=0;
        addFirst=3;
        addLast=4;
        capacity=8;
        a=(T[])new Object[capacity];
    }

    // index减少
    private int minusOne(int index,int length){
        if (index==0) return length-1;
        //Q:这里可能因为没有% 出现一些问题
        index=index%length;
        index-=1;
        return index;
    }

    // index 增加
    private   int addOne( int index,int length){
        if (index==length-1){
            return 0;
        }
        index=index%length;
        index+=1;
        return index;
    }

    // 用一个新数组去接收就好，addFirst就放到最前面，addLast就放到开头就好
    // 容量变成原来的2倍，
    // 例子：
    // 原数组：
    // 2 1 4 3
    // 现数组：
    // _           _           _           _            4 3 2 1
    //addLast                             addFirst
    //
    private void   resizeUp(int newCapacity){
        int temp=newCapacity/2;
        int i=0;
        //构建一个新的数组
        T newArray[]=(T[]) new Object[newCapacity];
        addFirst= addOne(addFirst,capacity);
        while (i<capacity) {
            newArray[temp]=a[addFirst];
            temp=addOne(temp,newCapacity);
            addFirst=addOne(addFirst,capacity);
            i++;
        }

        a=newArray;
        addFirst=(newCapacity/2)-1;
        addLast=0;
        capacity=newCapacity;
        return ;
    }

    //// 0 1 2 3 _ _ _ _ _ _ _
    //   _ 0 _ _
    private void resizeDown(int newCapacity){
        T newArray[]=(T[]) new Object[newCapacity];
        int temp=newCapacity/2;
        int i=0;
        int index=addOne(addFirst,capacity);
        addFirst=minusOne(temp,newCapacity);
        while (i<size()) {
            newArray[temp]=a[index];
            i++;
            index=addOne(index, capacity);
            temp=addOne(temp,newCapacity);
        }
        addLast=temp;
        capacity=newCapacity;
        a=newArray;

    }

    public void addFirst(T item){

        if (size==a.length){
            resizeUp(capacity*2);
        }
        a[addFirst]=item;
        size+=1;
        addFirst=minusOne(addFirst,capacity);
        return;
    }
    public void addLast(T item){
        if (size==a.length){
            resizeUp(capacity*2);
        }

        a[addLast]=item;
        size++;
        addLast=addOne(addLast,capacity);
        return;

    }
    public boolean isEmpty(){
        if (size==0) return true;
        return false;

    }
    public int size(){
        return size;

    }

// 直接用一个去打印，和尺寸比较就好了
    //
    public void printDeque() {
        if (size== 0) return;

        int first=addOne(addFirst,capacity);
        //和尺寸去比较
        int i=0;
                //minusOne(addLast, capacity);
        while (i<size) {

            System.out.println(a[first]);
            first=addOne(first,capacity);
            i+=1;
        }

        return;
    }
    public T removeFirst(){
        if (a.length==0 ) return null;
        int index=addOne(addFirst,capacity);
        T temp=a[index];
        addFirst=index;
        a[index]=null;
        size-=1;

        if (capacity!=8 && (float)size/capacity<0.25){
            resizeDown(capacity/2);
         }

        return temp ;
    }

    public T removeLast(){
        if (capacity==0 ) return null;
        int index=minusOne(addLast,capacity);
        T temp=a[index];
        addLast=index;
        size-=1;
        a[index]=null;
        if (capacity!=8 && (float)size/capacity<0.25){
            resizeDown(capacity/2);
        }

        return temp;
    }

    public T get(int index){
        int temp=addFirst;
        for (int i = 0; i < index+1; i++) {
            temp=addOne(temp,capacity);
        }
        return a[temp];

        
    }



}
