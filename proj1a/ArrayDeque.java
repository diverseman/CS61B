

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
    static int size;
    T a[];
    //容量
    int capacity;
    int addFirst;
    int addLast;
    public ArrayDeque(){
        size=0;
        a=(T[])new Object[capacity];
        addFirst=3;
        addLast=4;
        capacity=8;
    }

    // index减少
    public int minusOne(int index,int length){
        if (index==0) return length-1;
        //Q:这里可能因为没有% 出现一些问题
        index=index%length;
        return index--;
    }

    // index 增加
    public  int addOne( int index,int length){
        if (index==length-1){
            return 0;
        }
        index=index%length;
        return index++;
    }
    // 容量变成原来的2倍，
    // 例子：
    // 原数组：
    // 1 2 3 4
    // 现数组：
    // _           _           _           _            1  2  3  4
    //addLast                             addFirst
    public void   resizeUp(int newCapacity){

        int temp=capacity;

        int i=0;
        //构建一个新的数组
        T newArray[]=(T[]) new Object[newCapacity];
        while (i<capacity) {
            newArray[temp]=a[addLast];
            temp=addOne(temp,newCapacity);
            addLast=addOne(addLast,capacity);
            i++;
        }
        a=newArray;
        addFirst=capacity-1;
        addLast=addOne(temp,newCapacity);
        capacity=newCapacity;
        return ;
    }


    public void resizeDown(int newCapacity){
        T newArray[]=(T[]) new Object[newCapacity];
        int temp=newCapacity/2;
        int i=0;
        int index=addOne(addFirst,capacity);
        while (i<size()) {
            newArray[temp]=a[index];
            i++;
            index=addOne(index, capacity);
            temp=addOne(temp,newCapacity);
        }
        capacity=newCapacity;
        a=newArray;
    }
    //需要更改
    public void addFirst(T item){

        if (size==a.length){
            resizeUp(a.length*2);
        }
        a[addFirst]=item;
        size+=1;
        minusOne(addFirst,capacity);
        return;
    }
    public void addLast(T item){
        if (size==a.length){
            resizeUp(a.length*2);
        }

        a[addLast]=item;
        size++;
        addOne(addLast,capacity);

    }
    public boolean isEmpty(){
        if (size==0) return true;
        return false;

    }
    public int size(){
        return size;

    }

// 打印之后再说，感觉是 first 打印first的，last打印last的，需要在改
    public void printDeque() {
        if (size() == 0) return;
        //打印不对


        int index = addOne(addFirst, capacity);
        int res = minusOne(addLast, capacity);
        while (index != res) {
            //如果没有东西，那就略过 这里好像有问题，因为原数组 空的地方可能全为0
            if (a[index] == null) continue;
            System.out.println(a[index]);
            index = minusOne(index, capacity);
        }
    }
    public T removeFirst(){
        if (a.length==0 ) return null;
        int index=minusOne(addFirst,capacity);
        T temp=a[index];
        addFirst=index;
        a[index]=null;
        size--;
        if (size/capacity<0.25){
            resizeDown(capacity/2);
         }

        return temp ;
    }

    public T removeLast(){
        if (capacity==0 ) return null;
        int index=addOne(addLast,capacity);
        T temp=a[index];
        addLast=index;
        size--;
        a[index]=null;
        if (size/capacity<0.25){
            resizeDown(capacity/2);
        }

        return temp ;



    }

    public T get(int index){
        return a[index];

        
    }



}
