package leetcode;

/**
 * Created by mazhi on 2016/12/21.
 */
public class Bit_Manipulation {
    public static void main(String[] args) {
        int nums[] = {4,14,2};

        int size = totalHammingDistance(nums);
        System.out.println(size);
    }

    //    The Hamming distance between two integers is the number of positions
//    at which the corresponding bits are different.
//    Given two integers x and y, calculate the Hamming distance.
//    x,y二进制表示位数不同的个数
//    the best solution :Interger.bitcount;
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & 1) == 1) res++;
            xor = xor >> 1;
        }
        return res;
    }

    public static int hammingWeight(int n) {
        //   int result = 0;
        // while (n != 0) {
        //     result += n%2;
        //     n = n/2;
        // }
        // return result;
        return Integer.bitCount(n);
    }

    /*Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.*/
    public static int totalHammingDistance(int[] nums) {
        //O(n*n)
//        int len = nums.length;
//        int res = 0;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                res += Integer.bitCount(nums[i] ^ nums[j]);
//            }
//        }
//        return res;
        //O(n)
        int res_total=0;
        int len=nums.length;
        for(int i =0;i<32;i++){
            int bitCount=0;
            for(int j =0;j<len;j++)
                if(((nums[j]>>i) & 1)==1) bitCount++;
            res_total += bitCount * (len-bitCount);
        }
        return res_total;
    }

    public static  int myAtoi(String str) {
        return Integer.parseInt(str);
    }

}
