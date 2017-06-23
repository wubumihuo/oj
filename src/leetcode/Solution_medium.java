package leetcode;

/**
 * Created by mazhi on 2016/7/4.
 */
public class Solution_medium {
    //Find Peak Element 找数组中比两边值大的
    public static int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[len-1]>nums[len-2]) return len-1;
        for(int i = 1;i<nums.length-2;i++ ){
            if(nums[i]>nums[i-1]&&nums[i]<nums[i+1]) return i;
        }
        return 0;
    }
}
