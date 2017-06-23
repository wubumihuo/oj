package jianzhiOffer;

/**
 * Created by mazhi on 2017/4/18.
 */
public class DynamicProgram {
    public static int FindGreatestSumOfSubArray(int[] array) {
//        int max_sum=array[0];
//        int last_max=array[0];
//        for(int i=1;i<array.length;++i){
//            max_sum +=array[i];
//            if(max_sum>last_max) last_max=max_sum;
//            if(max_sum<0) max_sum=0;
//        }
//        return last_max;
        /*动态规划*/
        if(array.length==0) return 0;
        int sum = array[0],tempsum =array[0];
        for(int i=1;i<array.length;++i){
            tempsum = (tempsum<0) ? array[i]:tempsum+array[i];
            sum= (tempsum>sum)?tempsum:sum;
        }
        return sum;
    }
//需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
// 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
// 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
    public static void main(String[] args) {
        int []arr={-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
