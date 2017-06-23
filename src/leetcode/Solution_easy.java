package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mazhi on 2016/7/1.
 */
public class Solution_easy {
    //Given s = "hello", return "olleh".
//    public static String_handle reverse(String_handle s) {
//        int length = s.length();
//        String_handle reverse = "";
//        for (int i = 0; i < length; i++) {
//            reverse = s.charAt(i) + reverse;
//        }
//        return reverse;
//    }
//
//    // reverse vowels
//    public boolean isVowels(char c) {
//        c = Character.toLowerCase(c);
//        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
//            return true;
//        return false;
//    }
//
//    public String_handle reverseVowels(String_handle s) {
//        int i = 0;
//        int j = s.length() - 1;
//        char[] ss = s.toCharArray();
//        char temp;
//        while (i < j) {
//            while (i < j && (!isVowels(ss[i]))) {
//                i++;
//            }
//            while (i < j && (!isVowels(ss[j]))) {
//                j--;
//            }
//            // 交换两个ss[i]与ss[j]
//            temp = ss[i];
//            ss[i] = ss[j];
//            ss[j] = temp;
//            i++;
//            j--;
//        }
//        return new String_handle(ss);
//    }

    //Counting Bits 统计0-n的二进制数的1出现的次数
    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        results[0] = 0;
        if (num == 0) return results;
        else {
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 1) results[i] = results[i - 1] + 1;
                else results[i] = results[i / 2];
            }
            return results;
        }
    }

    //// you need to treat n as an unsigned value
    //返回n 的二进制数1的个数
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n = n >>> 1;   //无符号右移三位
        }
        return result;
    }

    // you need treat n as an unsigned value
    //二进制交换
    public int reverseBits(int n) {
        return 0;
    }

    //singleNumber 找出一数组中不重复的两个数
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i]; //重复的两个数亦或会得0
        }
        res[0] = 0;
        res[1] = 0;
        int n = result & (~(result - 1));  //找出两个数不一样的位
        for (int i = 0; i < nums.length; i++) {
            if ((n & nums[i]) != 0) {
                res[0] = res[0] ^ nums[i];  //根据那一位分成两个组分别找出
            } else {
                res[1] = res[1] ^ nums[i];
            }
        }
        return res;
    }

    //把一个数组的0元素移到数组末端
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0, j = length - 1;
        while (i <= j) {
            if (nums[i] == 0) {
                for (int begin = i; begin < j; begin++)
                    nums[begin] = nums[begin + 1];
                nums[j] = 0;
                j--;
            } else i++;  //如果第一个数为0，则下面继续从0开始。如果不是，则从第二个数开始
        }
    }

    //删除数组中对应的数,返回新数组的长度
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int newbegin = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[newbegin] = nums[i];   //用原数组 同时做新数组使用，因为即使没有相等的元素也不会影响后面数组的顺序和比较
                newbegin++;
            }
        }
        return newbegin;
    }

    //Remove Duplicates from Sorted Array在数组中删除重复原素
    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        int len = nums.length;
        while (j < len) {
            for (int k = 0; k <= j - 1; k++) {
                if (nums[k] == nums[j]) {
                    for (int l = j; l < len - 1; l++)
                        nums[l] = nums[l + 1];
                    j--;//跳出循环还要加一次
                    len--;
                    break;
                }
            }
            j++;
        }
        return len;
    }

    //   Given two arrays, write a function to compute their intersection. 找出数组中相同的元素,不需要重复
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interset = new HashSet<Integer>();
        for (int i = 0; i < len1; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < len2; i++) {
            if (set.contains(nums2[i])) interset.add(nums2[i]);
        }
        int[] result = new int[interset.size()];
        int cnt = 0;
        for (int num : interset) {
            result[cnt++] = num;
        }
        return result;
    }
    //Given two arrays, write a function to compute their intersection.  有多少重复就写出多少个
    //public int[] intersect(int[] nums1, int[] nums2) {

    //}
}
