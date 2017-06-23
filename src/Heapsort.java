/**
 * Created by mazhi on 2017/4/14.
 */
public class Heapsort {
    public static void main(String[] args) {
        int a[]={1,3,4,5,9,8,0,2,7,6};
        heapsort(a,10);
    }
    public static void heapsort(int a[],int len)
    {
        //构建最大堆  从
        for(int i=len/2-1;i>=0;i--)
        {
            heapfy(a,i,len);
        }
        for(int i=len-1;i>=0;i--)
        {
            swap(a,i,0);
            heapfy(a,0,i);
        }
    }
    public static void heapfy(int a[],int index,int heapsize)
    {
        int left=index*2+1;
        int right=left+1;
        int largest=index;
        if(left<heapsize&&a[index]<a[left])
            largest=left;
        if(right<heapsize&&a[largest]<a[right])
            largest=right;
        if(largest!=index)
        {
            swap(a,index,largest);
            heapfy(a,largest,heapsize);
        }
    }
    public static void swap(int []arr,int a_index,int b_index){
     int tmp = arr[a_index];
        arr[a_index] = arr[b_index];
        arr[b_index] =tmp;
    }
}
