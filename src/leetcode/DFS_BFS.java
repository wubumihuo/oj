package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mazhi on 2017/1/11.
 */
public class DFS_BFS {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*No:107. Binary Tree Level Order Traversal II
    *Given binary tree [3,9,20,null,null,15,7],
    *     3
         / \
        9  20
          /  \
        15   7
     * return   [
  [15,7],
  [9,20],
  [3]
]
     *  */
    //DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null) return wrapList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }

    //No:112Path Sum
    //Given a binary tree and a sum, determine if the tree has
    // a root-to-leaf path such that adding up all the values along the path equals the given sum.
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /*No:113. Path Sum II
    * Given a binary tree and a sum, find all root-to-leaf
    * paths where each path's sum equals the given sum.*/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> reList = new ArrayList<>();
        pathSumHelper(reList, new ArrayList<Integer>(), 0, root, sum);
        return reList;
    }

    private void pathSumHelper(List list, List<Integer> currList, int prev_sum, TreeNode root, int sum) {
        if (root == null) return;
        currList.add(root.val);
        int curr_sum = prev_sum + root.val;
        if (root.left == null && root.right == null && sum == curr_sum)
            list.add(currList);
        pathSumHelper(list, new ArrayList<Integer>(currList), curr_sum, root.left, sum);
        pathSumHelper(list, new ArrayList<Integer>(currList), curr_sum, root.right, sum);
    }

    /*No:437
    * 不一定要求从根节点到最后的叶子节点
    * */
    public int newpathSum(TreeNode root, int sum) {
        return 0;
    }

    /*No:110. Balanced Binary Tree
    * Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined
    as a binary tree in which the depth of the two subtrees of
    every node never differ by more than 1.
    * */
    public boolean isBalanced(TreeNode root) {
        if (root.left ==null && root.right==null) return true;
        return false;
    }


}
