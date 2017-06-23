package leetcode;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mazhi on 2016/12/26.
 */
public class Backtracking {
    /*No:131返回所有一个字符串所有子串都是回文字符串的可能
    *For example, given s = "aab",
    Return
    [
         ["aa","b"],
         ["a","a","b"]
        ]
     *  */
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

    /*No;22. Generate Parentheses
    * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
    * */
    public static List<String> generateParenthesis(int n) {
        List list = new ArrayList<>();
        String str="";
        generateBacktracking(list,str,n,n);
        return list;
    }

    public  static void generateBacktracking(List list,String str,int left_num ,int right_num){
        if(left_num==0&&right_num==0){
            list.add(str);
            return;
        }
        if(left_num>0) generateBacktracking(list,str+'(',left_num-1,right_num);
        if(right_num>left_num) generateBacktracking(list,str+')',left_num,right_num-1);
    }

    /*No:Letter Combinations of a Phone Number
    * Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
    * */

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {

        List<String> ret = new LinkedList<String>();
        if(digits.length()==0) return ret;
                combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

    /*No:78 subsets
    return all possible subsets
    * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(nums);
        subsetsBacktrack(reList, new ArrayList<>(), nums, 0);
        return reList;
    }
    private void subsetsBacktrack(List<List<Integer>> list , List<Integer> tempList,int []nums , int start){
        list.add(new ArrayList<>(tempList));
        for(int i =start;i<nums.length;i++){
            tempList.add(nums[i]);
            subsetsBacktrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size() -1);
        }
    }

    /*No:39. Combination Sum
    * Given a set of candidate numbers (C)
    * (without duplicates) and a target number (T),
    * find all unique combinations in C where the candidate numbers sums to T.*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(candidates);
        combinaHelper(reList,target,candidates,new ArrayList(),0,0);
        return reList;
    }
    private void combinaHelper(List list, int target, int [] nums, ArrayList currList,int currSum,int index){
        for(int i=index;i<nums.length;i++){
            int tmpSum =currSum+nums[i];
            ArrayList tmplist = new ArrayList(currList);
            tmplist.add(nums[i]);
            if(tmpSum==target)
            {
                list.add(tmplist);
                return;
            }
            else if(currSum<target) {
                combinaHelper(list,target,nums,tmplist,tmpSum,i);
            }
            else return;
        }
    }

    /*No:44. Wildcard Matching
    * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
    * */
    public boolean isMatch(String s, String p) {
        int sIndex=0,pIndex=0,match=0,startIndex=-1;
        while(sIndex<s.length()){
            if(pIndex<p.length()&&(p.charAt(pIndex)=='?'||s.charAt(sIndex)==p.charAt(pIndex))){
                sIndex++;
                pIndex++;
            }
            else if(pIndex<p.length()&&p.charAt(pIndex)=='*'){
                startIndex = pIndex;
                match = sIndex;
                pIndex++;
            }
            else if(startIndex!=-1){
                pIndex =startIndex+1;
                match++;
                sIndex=match;
            }
            else return false;
        }
        while (pIndex<p.length() && p.charAt(pIndex) == '*') pIndex++;
        return pIndex==p.length();
    }

    public static void main(String [] args){
        String math_str="23";
        List<String> list = new ArrayList<>();
        list = letterCombinations(math_str);
    }
}

