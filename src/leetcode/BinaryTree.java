package leetcode;

import java.util.*;

/**
 * Created by mazhi on 2017/1/10.
 */
public class BinaryTree {
    //Root node pointer.Will be null for an empty tree.
    private TreeNode root;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(0);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        postOrderTraverse(root);

    }

    // Definition for a binary tree node.
    public static class TreeNode {
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
    /*先序遍歷*/
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    // 先序遍历非递归
    public static void preOrder2(TreeNode node) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.empty()) {
            while (node != null) {
                System.out.print(node.val);
                s.push(node);
                node = node.left;
            }
            if (!s.empty()) {
                node = s.pop();
                node = node.right;
            }
        }
    }
    /*中序遍歷*/
    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }
    // 中序遍历非递归
    public static void InOrder2(TreeNode node) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.empty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            if (!s.empty()) {
                node = s.pop();
                System.out.print(node.val);
                node = node.right;
            }
        }
    }
    /*后序遍歷*/
    public static void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }
    // 后序遍历非递归
    public static void PostOrder2(TreeNode node) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack<Integer>();
        Integer i = new Integer(1);
        while (node != null || !s.empty()) {
            while (node != null) {
                s.push(node);
                s2.push(new Integer(0));
                node = node.left;
            }
            while (!s.empty() && s2.peek().equals(i)) {
                s2.pop();
                System.out.print(s.pop().val);
            }

            if (!s.empty()) {
                s2.pop();
                s2.push(new Integer(1));
                node = s.peek();
                node = node.right;
            }
        }
    }
    /*層序遍歷*/
    public static void levelTravel(TreeNode root){
        if(root==null)return;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp =  q.poll();
            System.out.println(temp.val);
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }
    }

    /*No:100. Same Tree
    * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. both empty -> true
        if (p == null && q == null)
            return (true);

            // 2. both non-empty -> compare them
        else if (q == null || q == null) {
            return false;
        }
        // 3. one empty, one not -> false
        else {
            return (q.val == q.val && isSameTree(p.left, q.left) && isSameTree(
                    p.right, q.right));
        }

    }

    /*No:101. Symmetric Tree
    * Given a binary tree, check whether
    * it is a mirror of itself (ie, symmetric around its center).
    * */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    /*No:102. Binary Tree Level Order Traversal
    * Given a binary tree, return the level order traversal of its nodes' values.
    * Given binary tree [3,9,20,null,null,15,7],
    *    3
        / \
       9  20
         /  \
        15   7
    *return:[
              [3],
              [9,20],
              [15,7]
            ]
     *  */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> reList = new ArrayList<>();
        levelHelper(reList, root, 0);
        return reList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> List = new ArrayList<>();
        levelHelper(List, root, 0);
        List<List<Integer>> reList = new ArrayList<>();
        int length= List.size();
        for(int i=0;i<length;i++){
            reList.add(List.get(length-1-i));
        }
        return reList;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    /*No:99. Recover Binary Search Tree
    二叉排序树；
    * Two elements of a binary search tree (BST) are swapped by mistake.
    Recover the tree without changing its structure.*/
    public void recoverTree(TreeNode root) {
        List<TreeNode> reList = new ArrayList<>();
        swappedFind(reList, root);
        int temp = reList.get(0).val;
        reList.get(0).val = reList.get(1).val;
        reList.get(1).val = temp;
    }

    private void swappedFind(List list, TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            if (node.left.val > node.val) {
                list.add(node.left);
                list.add(node);
            }
        }
        if (node.right != null) {
            if (node.right.val < node.val) {
                list.add(node.right);
                list.add(node);
            }
        }
        swappedFind(list, node.left);
        swappedFind(list, node.right);
    }

    /*No：94. Binary Tree Inorder Traversal
    中序遍历，左节点-父节点-右节点
    * Given a binary tree, return the inorder traversal of its nodes' values.
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    /*No:144. Binary Tree Preorder Traversal
    先序遍历
    * Given a binary tree, return the preorder traversal of its nodes' values.
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur == null) cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) stack.add(cur.right);
            cur = cur.left;

        }

        return list;
    }
    /*No:230. Kth Smallest Element in a BST
    找出BST中第k大的数，思路：先序遍历
    * */
    public int kthSmallest(TreeNode root, int k) {
        int reKth=0;
        int index=0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            index++;
            if(index == k) return cur.val;
            cur = cur.right;
        }
        return reKth;
    }

}
