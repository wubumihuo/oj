package leetcode;

import java.util.*;
import java.util.zip.CheckedInputStream;

/**
 * Created by mazhi on 2016/12/22.
 */
public class HashTablePerform {
    public static void main(String[] args) {
//        int []arr1={1,2,2,1};
//        int []arr2={2,2};
//        int res[]=intersect(arr1,arr2);
//        for(int i :res) System.out.println(i);

    }

    /*No:Given an array of size n, find the majority element.
   The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  * */
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        Map<Integer,Integer> myMap = new HashMap<Integer, Integer>();
        int ret = 0;
        for(int num:nums){
            if(!myMap.containsKey(num))
                myMap.put(num,1);
            else myMap.put(num,myMap.get(num)+1);
            if(myMap.get(num)>nums.length/2){
                ret=num;
                break;
            }
        }
        return ret;
    }

    /*Given two arrays, write a function to compute their intersection.
Example:  两个数组的交叉部分；
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].*/
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(nums1[i])) map.put(nums1[i], 1);
            else map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int resLen = list.size();
        int index = 0;
        int[] res = new int[resLen];
        for (Integer i : list) {
            res[index++] = i;
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid;
        }

        int[] res = new int[2];
        if (nums[mid] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = mid, right = mid;
        while (left > 0) {
            if (nums[left - 1] == nums[left]) left--;
            else break;
        }
        while (right < nums.length - 1) {
            if (nums[right + 1] == nums[right]) right++;
            else break;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }

    /*No:347. Top K Frequent Elements
    * Given a non-empty array of integers, return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
    *
    * */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rel = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < k; i++) {
            rel.add(list.get(i).getKey());
        }
        return rel;
    }

    /*No：451. Sort Characters By Frequency
    * Given a string, sort it in decreasing order based on the frequency of characters.
    * */
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++)
                res.append(list.get(i).getKey());
        }
        return res.toString();
    }

    /*No:217. Contains Duplicate
    * Given an array of integers, find if the array contains any duplicates. Your function should return true if any
     * value appears at least twice in the array, and it should return false if every element is distinct.
    * */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) return true;
            else map.put(n, 0);
        }
        return false;
    }

    /*No:219. Contains Duplicate II
    *Given an array of integers and an integer k, find out whether there are two distinct indices i
    * and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /*No:500. Keyboard Row
    * Given a List of words, return the words that can be typed using
    * letters of alphabet on only one row's of American keyboard like
    * the image below.
    * */
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for (String w : words) {
            if (w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for (char c : w.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if (index != -1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }


}
