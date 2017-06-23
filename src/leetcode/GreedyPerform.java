package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mazhi on 2016/12/24.
 */
public class GreedyPerform {
    /*No:122. Best Time to Buy and Sell Stock II
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like .
    * */
    public int maxProfit(int[] prices) {
        int total_profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total_profit += prices[i + 1] - prices[i];
        }
        return total_profit;
    }

    /*NO:455. Assign Cookies
    * */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int reCount = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                reCount++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return reCount;
    }

    /*NO;406. Queue Reconstruction by Height
    * Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    * */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            //前面大的数排好位置，自然后面小数就排好位置了
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    /*NO:44. Wildcard Matching
    * Implement wildcard pattern matching with support for '?' and '*'.
    * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).*/
    public boolean isMatch(String s, String p) {
        return false;
    }

    /*No:55. Jump Game
    *Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
*/
    public boolean canJump(int[] nums) {
        int max = 0;
        //说明每个点都能走到
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    /*No:45. Jump Game II
    * Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2.
     (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
    *
    * */
    public int jump(int[] nums) {
        return 0;
    }


}
