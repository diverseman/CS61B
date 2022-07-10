/*更改思路： 增加一个resizing，这个可以是O（n）的复杂度
resize(size*REFACTOR)
空间复杂度：usage ratio： SIZE/array.length
 halve the size of the array when R falls to less than 0.25.

目前只是一个非常朴素的实现，还需要进一步改进，几乎所有的函数
*/
public class ArrayDeque <T>{
    static int size;
    T a[];

    public ArrayDeque(){
        size=8;
        a=(T[])new Object[size];
    }
    //需要更改
    public void addFirst(T item){
        if (a.length<size()){
            for ( int i=0;i<size;i++){
                a[i+1]=a[i];
                if (i==0){
                    a[0]=item;
                }
            }
            size+=1;
            return ;
        }
        T b[] = (T[]) new Object[size()+1];
        for ( int i=0;i<size+1;i++){
            if (i==0) {
                b[0]=item;
                continue;
            }
            b[i]=a[i-1];
        }
        a=b;
        size+=1;
        return;
    }
    //需要更改
    public void addLast(T item){
        if (a.length<size()){
            a[a.length]=item;
            size+=1;
            return ;
        }
        else {
            T b[] = (T[]) new Object[size()+1];
            for ( int i=0;i<size+1;i++){
                if (i==size) {
                    b[size]=item;
                    break;
                }
                b[i]=a[i];
            }
            a=b;
            size+=1;

        }

        
    }
    public boolean isEmpty(){
        if (a.length==0) return true;
        return false;
        
    }
    public int size(){

        return size;
        
    }
    public void printDeque(){
        for (int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    //这里也需要更改
    public T removeFirst(){

        if (a.length==0 ) return null;
        T temp=a[0];
        if (a.length==1){
            size=0;
            return temp;
        }
        for ( int i=0; i<a.length;i++){
            a[i]=a[i+1];
        }
        size-=1;
        return temp;
    }
    //这里也需要更改
    public T removeLast(){
        if (a.length==0 ) return null;
        T temp=a[0];
        if (a.length==1){
            size=0;
            return temp;
        }
        T b[]=(T[]) new Object[a.length-1];
        for ( int i =0 ; i<a.length-1;i++){
            b[i]=a[i];
        }

        a=b;
        size-=1;
        return temp;
    }
    //这里需要更改
    public T get(int index){
        return a[index];

        
    }
    //更改
    public int minusOne(int index){
        return size();

    }


}
