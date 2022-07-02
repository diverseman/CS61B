
/*
a new version
 */
class SLList {
       private class IntNode {
           public int item;
           public IntNode next;
           public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
            }
}
        private IntNode first;
        public void addFirst(int x) {
        first = new IntNode(x, first);

        }
    /*Implement SLList.insert which takes in an integer x and inserts it at the given
    position. If the position is after the end of the list, insert the new node at the end.
   */
         public void insert(int item, int position) {

             if (position==0 || first==null){
                 addFirst(item);
                 return ;
             }
             IntNode temp=first;
             /*
             position-- 反向减 很可以
              */
             while (temp.next!=null && position>1 ){
                 temp=temp.next;
                 position-=1;
             }
             IntNode newNode=new IntNode(item,temp.next);
             temp.next=newNode;
             return;

         }
         public void reverse(){
             if(first==null||first.next==null){
                 return ;
             }
             IntNode head=null;
             while (first!=null){
                 IntNode temp=first.next;
                 first.next=head;
                 head=first;
                 first=temp;

             }
         }

}
class array{
    public  static int[] insert(int[] arr, int item, int position){
        int res[]=new  int[arr.length+1];
        /*
        这里的处理很漂亮，min(数组长度，position)
         */
        position=Math.min(arr.length, position);
        for (int i=0;i< position;i++){
            res[i]=arr[i];
            }
        res[position]=item;
        for (int i=position;i< arr.length;i++){
            res[i+1]=arr[i];
        }
        return res;

    }
    public static  void reverse(int arr[]){
        if (arr.length==1 || arr.length==0) return ;
        int head=0;
        int tail=arr.length-1;
        int temp;
        while (arr.length/2!=head){
            temp=arr[head];
            arr[head]=arr[tail];
            arr[tail]=temp;
            head++;
            tail++;
        }
        return ;
    }


}



