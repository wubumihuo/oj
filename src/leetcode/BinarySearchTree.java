package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2017/1/10.
 * 二叉排序树
 */
public class BinarySearchTree {
    //Root node pointer.Will be null for an empty tree.
    private TreeNode root;

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //    create an empty binary tree
    public void BinaryTree() {
        root = null;
    }
    /**
     * Returns true if the given target is in the binary tree. Uses a recursive
     * helper.
     */
    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
     * Recursive lookup -- given a node, recur down searching for the given
     * data.
     */
    private boolean lookup(TreeNode node, int data) {
        if (node == null) {
            return (false);
        }
        if (data == node.val) {
            return (true);
        } else if (data < node.val) {
            return lookup(node.left, data);
        } else {
            return (lookup(node.right, data));
        }
    }

    /**
     * Inserts the given data into the binary tree. Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Recursive insert -- given a node pointer, recur down and insert the given
     * data into the tree. Returns the new node pointer (the standard way to
     * communicate a changed pointer back to the caller).
     */
    private TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (data <= node.val) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return (node); // in any case, return the new pointer to the caller
    }

    /**
     * Returns the number of nodes in the tree. Uses a recursive helper that
     * recurs down the tree and counts the nodes.
     */
    public int size() {
        return (size(root));
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + size(node.right) + 1);
        }
    }
    // //////////////////////////////max depth/////////////////////////////////
    /**
     * Returns the max root-to-leaf depth of the tree. Uses a recursive helper
     * that recurs down to find the max depth.
     */
    public int maxDepth() {
        return (maxDepth(root));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lMaxDepth = maxDepth(root.left);
            int rMaxDepth = maxDepth(root.right);
            // use the larger + 1
            return Math.max(lMaxDepth, rMaxDepth) + 1;
        }
    }
    // ////////////////////////////////////////////////
    /**
     * Finds the min value in a non-empty binary search tree.
     */
    public int minValue() {
        return (minValue(root));
    }

    // 最小值在最左子树最左的孩子
    private int minValue(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;

    }
    /**
     * Finds the min value in a non-empty binary search tree.
     */
    public int maxValue() {
        return (maxValue(root));
    }

    // 最大值在最右子树最右的孩子
    private int maxValue(TreeNode root) {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;

    }

    // ///////////////////////////////////////////////////////////////////
    /*
     * Compares the receiver to another tree to see if they are structurally
     * identical.
     */
    public boolean sameTree(BinarySearchTree other) {
        return (sameTree(root, other.root));
    }

    /**
     * Recursive helper -- recurs down two trees in parallel, checking to see if
     * they are identical.
     */
    boolean sameTree(TreeNode a, TreeNode b) {
        // 1. both empty -> true
        if (a == null && b == null)
            return (true);

            // 2. both non-empty -> compare them
        else if (a != null && b != null) {
            return (a.val == b.val && sameTree(a.left, b.left) && sameTree(
                    a.right, b.right));
        }
        // 3. one empty, one not -> false
        else
            return (false);
    }

    /*No:108. Convert Sorted Array to Binary Search Tree
  *Given an array where elements are sorted in ascending order,
   *  convert it to a height balanced BST.
   *  */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = seatHelper(nums, 0, nums.length - 1);
        return head;
    }
    private TreeNode seatHelper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = seatHelper(num, low, mid - 1);
        node.right = seatHelper(num, mid + 1, high);
        return node;
    }
    /*No:109. Convert Sorted List to Binary Search Tree
    * */
    public TreeNode sortedListToBST(NodePerform.ListNode head) {
        NodePerform.ListNode curr = head;
        List<Integer> list = new ArrayList<>();
        while(curr!=null) {
            list.add(curr.val);
            curr=curr.next;
        }
        if(list.size()==0) return null;
        return seatListHelper(list,0,list.size()-1);
    }
    private TreeNode seatListHelper(List<Integer> list,int low,int high){
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = seatListHelper(list, low, mid - 1);
        node.right = seatListHelper(list, mid + 1, high);
        return node;
    }
    //No.95  Given an integer n, generate all structurally unique
// BST's (binary search trees) that store values 1...n.
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return genTrees(1,n);
    }
    public List<TreeNode> genTrees (int start, int end)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end)
        {
            list.add(null);
            return list;
        }
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public void main(String [] args){

    }


}
