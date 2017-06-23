package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mazhi on 2016/7/19.
 */
public class String_handle {
    //找出最大的子字符串的长度
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int prev = 0;
        boolean[] letter = new boolean[256];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!letter[s.charAt(i)])
                letter[s.charAt(i)] = true;
            else {
                while (s.charAt(prev) != s.charAt(i)) {
                    letter[s.charAt(prev)] = false;
                    prev++;
                }
                prev++;
            }
            max = Math.max(max, i - prev + 1);
        }
        return max;
    }

    //求最大回文字符串
    public String longestPalindrome(String s) {
        int strlen = s.length();
        if (s.length() == 0) return "";
        int maxLen = 0;
        String res = "";
        int left, right;
        for (int i = 0; i < strlen * 2 - 1; i++) {
            if (i % 2 == 0) {
                left = i / 2 - 1;
                right = i / 2 + 1;
            } else {
                left = i / 2;
                right = i / 2 + 1;
            }
            String str = getPalindrome(s, left, right);
            if (maxLen < str.length()) {
                maxLen = str.length();
                res = str;
            }

        }
        return res;
    }

    public String getPalindrome(String s, int left, int right) {
        while ((left > 0) && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    //First Unique Character in a String
    /*s = "leetcode"
    return 0.

    s = "loveleetcode",
            return 2.
            */
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    //add Strings
    //Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (i1 >= 0 || i2 >= 0) {
            int n1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int n2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            i1--;
            i2--;
            sum = sum + n1 + n2;
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0)
            sb.append(sum);
        return sb.reverse().toString();
    }

    //Isomorphic Strings
//    Given "egg", "add", return true.
//    Given "foo", "bar", return false.
//    Given "paper", "title", return true.
    public class Solution {
        public boolean isIsomorphic(String s, String t) {
            return true;
        }
    }

    //Find the Difference
    //Given two strings s and t which consist of only lowercase letters.
    public char findTheDifference(String s, String t) {
        char[] charArray = (s + t).toCharArray();
        char res = 0;
        for (char elem : charArray) {
            res ^= elem;
        }
        return res;
    }

    //Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
    //思路：找字符串长度的除数
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int m = len / i;
                String subStr = str.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!subStr.equals(str.substring(j * i, j * i + i))) break;
                }
                if (j == m) return true;
            }
        }
        return false;
    }

    //ZigZag Conversion
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int n = s.length();
        int step = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += step) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j + step - 2 * i < n) {
                    sb.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return sb.toString();
    }

    /*
    * 14. Longest Common Prefix
    * Write a function to find the longest common prefix string amongst an array of strings.
    * */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int pre_len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0) return "";
            for (int j = 0; j < pre_len && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    pre_len = j;
                    break;
                }
                if (j == strs[i].length() - 1) {
                    pre_len = j + 1;
                    break;
                }
            }
        }
        return strs[0].substring(0, pre_len);
    }

    /*NO:151. Reverse Words in a String
    Given s = "the sky is blue",
return "blue is sky the".
    * */
    public static String reverseWords(String s) {
        String[] tmp = s.split(" +");
        if (tmp.length == 0) return "";
        StringBuilder restr = new StringBuilder();
        int length = tmp.length;
        for (int i = length - 1; i >= 0; i--) {
            restr.append(tmp[i]);
            restr.append(" ");
        }
        return restr.toString();
    }

    /*No:392:Is Subsequence
    * */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j >= t.length()) return false;
            while (s.charAt(i) != t.charAt(j)) {
                j++;
                if (j >= t.length()) return false;
            }
            j++;
        }
        return true;
    }

    /*No:394. Decode String
    *Given an encoded string, return it's decoded string.
     *s = "3[a]2[bc]", return "aaabcbc".
      s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
      * */
    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> levelStr = new Stack<>();
        char[] charArr = s.toCharArray();
        String reStr = "";
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '[') {
            } else if (charArr[i] >= '0' && charArr[i] <= '9') {
                if (i > 0 && charArr[i - 1] >= '0' && charArr[i - 1] <= '9') {
                    count.push(count.pop() * 10 + Integer.parseInt(String.valueOf(charArr[i])));
                } else {
                    count.push(Integer.parseInt(String.valueOf(charArr[i])));
                    levelStr.push("");
                }
            } else if (charArr[i] == ']') {
                String tmpStr = levelStr.pop();
                String currLevelStr = "";
                int tmpCount = count.pop();
                for (int j = 0; j < tmpCount; j++) {
                    currLevelStr += tmpStr;
                }
                if (!count.isEmpty()) {
                    levelStr.push(levelStr.pop() + currLevelStr);
                } else reStr += currLevelStr;
            } else {
                if (!count.isEmpty()) {
                    levelStr.push(levelStr.pop() + charArr[i]);
                } else reStr += charArr[i];
            }
        }
        return reStr;
    }

    /*No:54. Spiral Matrix
    *[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
     *return [1,2,3,6,9,8,7,4,5].
     * 螺旋返回
      * */
    public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> reList = new ArrayList<>();
        return reList;

    }


    public static void main(String[] args) {

        int [][] matrix = new int[5][5];
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                matrix[i][j] = i*5+j+1;

        spiralOrder(matrix);
    }
}
