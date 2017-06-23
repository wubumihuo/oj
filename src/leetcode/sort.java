package leetcode;


import java.lang.reflect.Array;

/**
 * Created by mazhi on 2016/10/20.
 */
public class sort {
    public static void  main(String []args)
    {
        int []a = {3,1,5,7,2,4,9,6};
        selectSort(a);
        for(int b:a) System.out.println(b);
    }
    void InsertSort(int a[],int n){
        for(int i=0;i<n;i++){

        }
    }
    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    public static void selectSort(int numbers[]){
        int len=numbers.length;
        for(int i=0;i<len;i++){
            int k=i;//确定排位置的index
//            for(int j=len-1;j>i;j--){
//                if(numbers[j]<numbers[k]){
//                    k=j;
//                }
//            }
            for(int j=i+1;j<len;j++){
                if(numbers[j]<numbers[k]) k=j;
            }
            int temp=numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=temp;
        }
    }
    /*
    * * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。 */
    public static void bubblesort(int [] numbers){
        int len=numbers.length;
        for(int i =0;i<len-1;i++)
        {
            for(int j=0;j<len-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
    }
    /*插入排序:
    从第二个数开始，每个数拿出来与前列已经排好序的数中，选择合适的顺序。
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *  */
    public static void insertSort(int [] numbers){
        int len=numbers.length;
        int j=0;
        for(int i=0;i<len;i++){
            int temp=numbers[i];
            for(j=i;j>0&&temp<numbers[j-1];j--)
                numbers[j]=numbers[j-1];
            numbers[j]=temp;
        }
    }
    //快速排序
    //通过一趟排序将待排序记录分割成独立的两部分，
    // 其中一部分记录的关键字均比另一部分关键字小，
    // 则分别对这两部分继续进行排序，直到整个序列有序。
    /**
     * 快速排序
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers)
    {
        if(numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length-1);
        }
    }
    /**
     *
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
            int middle = Partition(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }
    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int Partition(int[] numbers, int low,int high)
    {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high)
        {
            while(low < high && numbers[high] > temp)
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }

    /**希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     *实现数组从大到小排
     */

    public static void shellSort(int[] data)
    {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.length; i++)
            {
                temp = data[i];
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp > data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                    }
                    else
                    {
                        break;
                    }

                }
                data[j] = temp;
            }

        }
    }



}
