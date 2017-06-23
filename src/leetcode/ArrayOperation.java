package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mazhi on 2016/12/6.
 */
public class ArrayOperation {

    public static void main(String[] args) {
       String str="Hello World";
        System.out.println(lengthOfLastWord(str));
    }

    /*No;169. Majority Element
    * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    You may assume that the array is non-empty and the majority element always exist in the array.
    * */

    public int majorityElement(int[] nums) {
return 0;
    }
    /*No:58. Length of Last Word
   * */
    public static int lengthOfLastWord(String s) {
        boolean flagChar=false;
        int indexTail=0;
        for(int i =s.length()-1;i>=0;i--){
            if(!flagChar&&s.charAt(i)!=' ') {
                flagChar=true;
                indexTail = i;
            }
            if(s.charAt(i)==' '&&flagChar) return (indexTail - i);
        }
        if(flagChar) return indexTail+1;
        else return 0;
    }

    //Given an array of integers, every element appears three times except for one. Find that single one.
    //每一个数都会出现三次，则可以用模3除法，最后多出来的那一位就可以
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum = (sum + 1) % 3;
                }
            }
            if (sum > 0) {
                res = res + (sum << i);
            }
        }
        return res;
    }

    /*No;448
    *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
    * some elements appear twice and others appear once.
    Find all the elements of [1, n] inclusive that do not appear
    in this array.
    Could you do it without extra space and in O(n) runtime?
    You may assume the returned list does not count as extra space.
    * 思路：从1排到n，如果一个数x出现过，就在数组第x数上加n，这样再遍历一遍，小于n的指标就是没有出现过的
    * */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int temp = (nums[i] - 1) % n; //下标处理
            nums[temp] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) list.add(i + 1);
        }
        return list;
    }

    /*No:442
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
 * 思路：由上题可知，出现两次的数 在位置上应该是大于2n的
 * */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = (nums[i] - 1) % n; //下标处理
            nums[temp] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) list.add(i + 1);
        }
        return list;
    }

    /*No:118
    *For example, given numRows = 5,
    * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
    * */
    public List<List<Integer>> generate(int numRows) {
        List list = new ArrayList<>();
        if (numRows < 1) return list;
        else {
            List<Integer> prelist = new ArrayList<>();
            prelist.add(1);
            list.add(prelist);
            for (int i = 2; i < numRows + 1; i++) {
                List<Integer> nowlist = new ArrayList<>();
                nowlist.add(1);
                for (int j = 1; j < i - 1; j++) {
                    nowlist.add(prelist.get(j - 1) + prelist.get(j));
                }
                nowlist.add(1);
                prelist = nowlist;
                list.add(prelist);
            }
        }
        return list;
    }

    /*No:119
    * Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].*/
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        if (rowIndex < 1) return list.get(0);
        else {
            List<Integer> prelist = new ArrayList<>();
            prelist.add(1);
            list.add(prelist);
            for (int i = 2; i < rowIndex + 1; i++) {
                List<Integer> nowlist = new ArrayList<>();
                nowlist.add(1);
                for (int j = 1; j < i - 1; j++) {
                    nowlist.add(prelist.get(j - 1) + prelist.get(j));
                }
                nowlist.add(1);
                prelist = nowlist;
                list.add(prelist);
            }
        }
        return list.get(list.size() - 1);
    }

    /*No:15
    * Given an array S of n integers, are there elements a, b, c
     * in S such that a + b + c = 0? Find all unique triplets in
      * the array which gives the sum of zero.
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res_list = new ArrayList<>();
        if (nums.length < 3) return res_list;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res_list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if (sum <= 0) while (nums[j] == nums[++j] && j < k) ;
                if (sum >= 0) while (nums[k--] == nums[k] && j < k) ;
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) ;
        }
        return res_list;
    }

    /*No;238. Product of Array Except Self
    *  given [1,2,3,4], return [24,12,8,6].
    * */
    public static int[] productExceptSelf(int[] nums) {
        //因为存在0，所以不能使用除法
        //采用两个方向的方法，
        /*r1=1
        r2=a1
        r3=a1*a2
        rn = a1*a2....*an-1
        * */
        int len = nums.length;
        int[] res = new int[len];
        int tmp=1;
        for(int i =0;i<len;i++){
            res[i] = tmp;
            tmp =tmp*nums[i];
        }
        tmp=1;
        for(int i=len-1;i>=0;i--){
            res[i]=res[i]*tmp;
            tmp = tmp*nums[i];
        }
        return res;
    }

    /*No：414. Third Maximum Number
    * Given a non-empty array of integers, return the third
     * maximum number in this array. If it does not exist,
     * return the maximum number. The time complexity must be in O(n).
    * */
    public static int thirdMax(int[] nums) {
        int max, mid, small, count;
        max = mid = small = Integer.MIN_VALUE;
        boolean min_flag=false;
        count = 0;  //Count how many top elements have been found.

        for( int x: nums) {
            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
            if( x == max || x == mid ) {
                if(x==Integer.MIN_VALUE) min_flag=true;
                continue;
            }

            if (x > max) {
                //right shift
                small = mid;
                mid = max;

                max = x;
                count++;
            } else if( x > mid) {
                //right shift
                small = mid;

                mid = x;
                count++;
            } else if ( x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
                small = x;
                count++;
            }
        }

        //"count" is used for checking whether found top 3 maximum elements.
        count = min_flag?count+1:count;
        if( count >= 3) {
            return small;
        } else {
            return max;
        }
    }
}
