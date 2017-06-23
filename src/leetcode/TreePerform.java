package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2016/9/29.
 */
public class TreePerform {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*No:96.Unique Binary Search Trees
    *Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
    * dp[n] = dp[0]*dp[n-1]+dp[1]*dp[n-2]+....+dp[n-1]*dp[0];
    * */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++)
            for (int root = 1; root <= level; root++)
                dp[level] += dp[level - root] * dp[root - 1];
        return dp[n];
    }

    /*No:95. Unique Binary Search Trees II
    *your program should return all 5 unique BST's shown below.
     *  */
    public static List<TreeNode> generateTrees(int n) {
        return backGenerateTrees(1,n);
    }
    private static ArrayList<TreeNode> backGenerateTrees(int left, int right){
        ArrayList<TreeNode> res=new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }
        for(int i =left;i<=right;i++){
            ArrayList<TreeNode> lefts = backGenerateTrees(left,i-1);
            ArrayList<TreeNode> rights = backGenerateTrees(i+1,right);
            for(int j=0;j<lefts.size();j++){
                for(int k=0;j<rights.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(i);
                    root.right=rights.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }


    //    Find the sum of all left leaves in a given binary tree.
//            3
//            / \
//            9  20
//            /  \
//            15   7
//
//    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return list;
    }

    public static void main(String [] args){
        generateTrees(4);
    }

}
