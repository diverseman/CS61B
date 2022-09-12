package WeightedQuickUnionPathCompression;



public class WeightedQuickUnionPathCompression {
    private int parent[];
    private int size[];

    //把 所有的parent放在一个数组里，数值定义为原数值
    public WeightedQuickUnionPathCompression(int N){
         parent=new int[N];

         size=new int[N];
        for (int i = 0; i < N; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public boolean isConnected( int p ,int q){
        return find(p)==find(q);

    }

    public  int size(){
        return size[0];
    }
    private int find(int p) {
        if (p==parent[p]) return p ;
        parent[p]=find(parent[p]);
        return parent[p];
    }
    public void Connect( int p ,int q ){

        int i=find(p);
        int j=find(q);
        if (i==j)   return;
        if (size[i]<size[j]){
            parent[i]=j;
            size[j]+=size[i];

        }
        else {
            parent[j]=i;
            size[i]+=size[j];
        }
        return;
    }
    public void  print(){


        System.out.println();
    }

    public static void main(String[] args) {

        WeightedQuickUnionPathCompression res=new WeightedQuickUnionPathCompression(5);
        res.Connect(0,4);
        res.Connect(1,4);
        System.out.println(res.size());
        System.out.println(res.parent
                [1]);


    }


}
