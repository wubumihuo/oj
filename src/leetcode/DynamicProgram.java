package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2017/1/3.
 */
public class DynamicProgram {
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

//NO.10 '.' Matches any single character.
//'*' Matches zero or more of the preceding element.
    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    /*No:53. Maximum Subarray kadane算法
    * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
    * */
    public int maxSubArray(int[] nums) {
        int max_sofar=nums[0],max_here=nums[0];
        for(int i=1;i<nums.length;i++){
            max_here=Math.max(nums[i],max_here+nums[i]);
            max_sofar=Math.max(max_sofar,max_here);
        }
        return max_sofar;
    }
    /*No:70. Climbing Stairs
    * You are climbing a stair case. It takes n steps to reach to the top.
     Each time you can either climb 1 or 2 steps.
    In how many distinct ways can you climb to the top?
    * */
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        //an-1,an-2,an,
        int a_n_1=2,a_n_2=1,res_n=0;
        for(int i=3;i<=n;i++){
            res_n = a_n_1 +a_n_2;
            a_n_2 = a_n_1;
            a_n_1 = res_n;
        }
        return res_n;
    }
    /*
    * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
    For example,
    Given n = 3, there are a total of 5 unique BST's.*/
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }
    /*No:121. Best Time to Buy and Sell Stock
    只能操作一次
    *Input: [7, 1, 5, 3, 6, 4]
     Output: 5
     *  */
    public static int maxProfit(int[] prices) {
//        int max_sofar=0,max_here=0;
//        for(int i=1;i<prices.length;i++){
//            max_here=Math.max(0,max_here+= (prices[i]-prices[i-1]));
//            max_sofar=Math.max(max_sofar,max_here);
//        }
//        return max_sofar;
        if(prices.length<1) return 0;
        int min=prices[0];
        int max_profit =  0;
        for(int i=1;i<prices.length;i++){
            max_profit = Math.max(max_profit,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max_profit;


    }
    /*No:152. Maximum Product Subarray
    *For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
    * */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    /*No:198. House Robber
    *思路：动态规划
     *  f(n) = Math.max(nums[n-1]*f(n-3),nums[n-2]*f(n-4))
     *  */
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        int maxRe[] = new int [len+1];
        maxRe[0]=0;
        maxRe[1]=nums[0];
        maxRe[2]=Math.max(nums[0],nums[1]);
        for(int i =2;i<len;i++){
            maxRe[i+1] = Math.max(nums[i]+maxRe[i-1],nums[i-1]+maxRe[i-2]);
        }
        return maxRe[len];
    }
    /*No:House Robber II
    * 房屋环绕分配
    * 考虑两种可能，即是第一个不存在，和最后一个不存在
    * */
    public int rob2(int [] nums){
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        int nums1[] =new int[len-1];
        int nums2[] = new int[len-1];
        for(int i=0;i<len-1;i++){
            nums1[i]=nums[i];
            nums2[i]=nums[i+1];
        }
        return Math.max(rob(nums1),rob(nums2));
    }


    /*No:357. Count Numbers with Unique Digits
   * Given a non-negative integer n,
   * count all numbers with unique digits, x, where 0 ≤ x < 10n.
Example:
Given n = 2, return 91. (The answer should be the total
numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
   * */
    public int countNumbersWithUniqueDigits(int n) {
        int [] arr_single = new int[n];
        arr_single[0] = 10;
        arr_single[1] = 81;
        for(int i=2;i<n;i++){
            int tmp = (10-i)>=0 ? (10-i):0;
            arr_single[i]=arr_single[i-1]*tmp;
        }
        int res=0;
        for(int i =0;i<n;i++){
            res =res + arr_single[i];
        }
        return res;
    }
    /*No:413. Arithmetic Slices
    找出所有的递增序列切片
    * A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in
A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.*/
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int tmp_conti = 2;//认为 A1-A0是一个递增序列
        int diff = A[1]-A[0];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==diff) tmp_conti++;
            else {
                diff = A[i]-A[i-1];
                if(tmp_conti>=3) list.add(tmp_conti);
                tmp_conti =2;
            }
        }
        if(tmp_conti>=3) list.add(tmp_conti);
        if(list.size()==0) res=0;
        else {
            for(int n:list){
                res+= (n-3)*n/2 +1;
            }
        }
        return res;
    }






}
