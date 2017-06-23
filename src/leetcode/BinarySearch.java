package leetcode;

import java.util.HashMap;

/**
 * Created by mazhi on 2017/1/3.
 */
public class BinarySearch {
    /*No:167. Two Sum II - Input array is sorted
    Given an array of integers that is already sorted
    in ascending order, find two numbers such
    that they add up to a specific target number.
    *Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     *  */
    public static int[] twoSum(int[] numbers, int target) {

        int len=numbers.length;
        int [] resNum = {-1,-1};
        //二分法
        if(numbers ==null || len<2) return resNum;
        int left=0,right=len-1;
        while(left<right){
            int v = numbers[left]+numbers[right];
            if(v==target){
                resNum[0]=left+1;
                resNum[1]=right+1;
                break;
            }else if(v>target){
                right--;
            }else {
                left++;
            }
        }
        return resNum;
        // hashtable
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        for(int i = 0;i<len;i++){
//            hashMap.put(numbers[i],i+1);
//        }
//        for(int i =0;i<len;i++){
//            if(hashMap.containsKey(target - numbers[i])){
//                resNum[0]=i+1;
//                resNum[1]=hashMap.get(target - numbers[i]);
//                return resNum;
//            }
//        }
//        return resNum;
    }
    public static void main(String [] args){
        int [] arr = {2,3,4};
        twoSum(arr,6);
    }
}
