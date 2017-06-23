package leetcode;

import java.util.Hashtable;

/**
 * Created by mazhi on 2016/9/19.
 */
public class September {
    //给一个数组和一个target，返回该数组中两个数相加之和是它的
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        Hashtable<Integer, Integer> numbers = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = numbers.get(nums[i]);
            if (n == null) numbers.put(nums[i], i);
            n = numbers.get(target - nums[i]);
            if (n != null && n < i) {
                a[0] = n;
                a[1] = i;
                return a;
            }
        }
        return a;
    }
}
