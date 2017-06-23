package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mazhi on 2017/1/9.
 */
public class TwoPoints {
    /*No:15 3Sum
    * For example, given array S = [-1, 0, 1, 2, -1, -4],
       A solution set is:
       [
           [-1, 0, 1],
           [-1, -1, 2]
       ]
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k && nums[j] <= target) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    /*No:16. 3Sum Closest
    * Given an array S of n integers, find three integers in S
     * such that the sum is closest to a given number, target.
      * Return the sum of the three integers. */
    public static int threeSumClosest(int[] nums, int target) {
        int resCloset = Integer.MAX_VALUE;
        int sum=0;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int tmp = target - nums[i];
            while (j < k) {
                int reduction = tmp - nums[j] - nums[k];
                if(reduction==0) return target;
                else if (reduction>0) j++;
                else k--;
                if(Math.abs(reduction)<Math.abs(resCloset)){
                    resCloset=Math.abs(reduction);
                    sum = target - reduction;
                }
            }
        }
        return sum;
    }
    public static void main(String [] args){
        int []arr={1,2,4,8,16,32,64,128};
        int target =82;
        threeSumClosest(arr,target);
    }
}
