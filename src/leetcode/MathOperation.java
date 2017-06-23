package leetcode;

/**
 * Created by mazhi on 2016/12/30.
 */
public class MathOperation {
    /*No:67. Add Binary
    * Given two binary strings, return their sum (also a binary string).
    For example,
    a = "11"
    b = "1"
    Return "100".
    * */
    public String addBinary(String a, String b) {
        return "";
    }

    /*No;453
    Given a non-empty integer array of size n, find the minimum number of moves
     required to make all array elements equal, where a move is incrementing n - 1
     elements by 1.
     给一个数组，长度为n，每次操作n-1个数 +1 ，直到数组中每个数都一样
     思路：相当于每个元素每次减1，直到数组中每个数相等；
     所以要找数组中最小的一个数
*/
    public int minMoves(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int res = 0;
        int min = nums[0];
        for (int i = 0; i < len; i++) min = Math.min(min, nums[i]);
        for (int i = 0; i < len; i++) res += (nums[i] - min);
        return res;
    }

    /*No:462
    * Minimum Moves to Equal Array Elements II
    * Given a non-empty integer array, find the minimum number of moves required
    * to make all array elements equal, where a move is incrementing a selected
    * element by 1 or decrementing a selected element by 1.
    * */
    public static int minMoves2(int[] nums) {
        int sum  =0,ave_left=0 , ave_right=0 ,res_left=0,res_right=0;
        for (int i = 0;i<nums.length;i++ ){
            sum+=nums[i];
        }
        ave_left = sum/nums.length;
        ave_right = ave_left+1;
        for(int i = 0;i<nums.length;i++){
            res_left += Math.abs(nums[i]-ave_left);
            res_right += Math.abs(nums[i]-ave_right);
        }
        return Math.min(res_left,res_right);
    }

    /*No:Reconstruct Original Digits from English
    *Given a non-empty string containing an
    * out-of-order English representation of
    * digits 0-9, output the digits in ascending order. */

    public String originalDigits(String s) {
        return "";
    }

    /*No:168
    * Given a positive integer, return its corresponding column title as appear in an Excel sheet.*/
    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }

/*No;171. Excel Sheet Column Number
* Given a column title as appear in an Excel sheet, return its corresponding column number.*/
public static int titleToNumber(String s) {
    int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
        result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
}

    /*
    * Given an integer n, return the number of trailing zeroes in n!.*/

    public static void main(String [] args){
        System.out.println(titleToNumber("BA"));
    }
}
