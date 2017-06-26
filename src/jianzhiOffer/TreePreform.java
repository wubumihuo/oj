package jianzhiOffer;

import leetcode.BinaryTree;
import leetcode.TreePerform;

import java.util.*;

/**
 * Created by mazhi on 2017/3/22.                                                                                                                                              你
 */
public class TreePreform
{
    //求二叉树的深度
    public int TreeDepth(TreeNode pRoot){
        if(pRoot ==null) return 0;
        int left=TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return Math.max(left,right) +1;
    }
//判断是否是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        return height(root)!=-1;
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=height(node.right);
        if(rH==-1){
            return -1;
        }
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root =null;
        if(pre.length==0 || in.length==0) return root;
        root = new TreeNode(pre[0]);
        int i=0;
       for(;i<in.length;i++){
           if(in[i]==pre[0]) break;
       }
        int[] arr_left_pre =new int[i] ;
        int[] arr_left_in = new int[i];
        int[] arr_right_pre = new int[in.length-1-i];
        int[] arr_right_in = new int[in.length-1-i];
        for(int j=0;j<i;j++){
            arr_left_in[j] = in[j];
            arr_left_pre[j] = pre[j+1];
        }
        for(int j=0;j<(in.length-i-1);j++){
            arr_right_in[j] =in[j+i+1];
            arr_right_pre[j] = pre[j+i+1];
        }
        root.left = reConstructBinaryTree(arr_left_pre,arr_left_in);
        root.right = reConstructBinaryTree(arr_right_pre,arr_right_in);
        return root;
    }

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> reList = new ArrayList();
        if(root==null) return reList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            reList.add(node.val);
        }
        return reList;
    }

    //输入一颗二叉树和一个整数，打印出二叉树中结点值
    // 的和为输入整数的所有路径。路径定义为从树的根
    // 结点开始往下一直到叶结点所经过的结点形成一条路径。
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> relist =new ArrayList<>();
        Stack<Integer> chosenstack=new Stack<>();
        searchAll(root,chosenstack,target,relist);
        return relist;
    }

    public static void searchAll(TreeNode root, Stack<Integer> chosenstack,int target,ArrayList<ArrayList<Integer>> relist){
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null){
            if(root.val==target) {
                ArrayList<Integer> list =new ArrayList<>();
                for(int a:chosenstack)
                    list.add(a);
                list.add(root.val);
                relist.add(list);
            }
            return;
        }
        else {
            chosenstack.push(root.val);
            searchAll(root.left,chosenstack,target-root.val,relist);
            searchAll(root.right,chosenstack,target-root.val,relist);
            chosenstack.pop();
        }
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length<=0) return false;
        int root=sequence[sequence.length-1];
        int i=0;
        //在二叉搜索树中左子树的结点小于根节点
        for(;i<sequence.length-1;++i){
            if(sequence[i]>root) break;
        }
        //在二叉搜索树中右子树的结点大于根节点
        int j=i;
        for(;j<sequence.length-1;++j){
            if(sequence[j]<root) return false;
        }
        boolean left =true;
        if(i>0) left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));

        boolean right=true;
        if (i<sequence.length-1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length-1));
        return (left&&right);
    }
//给定一颗二叉搜索树，请找出其中的第k大的结点。
// 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
// 按结点数值大小顺序第三个结点的值为4。
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        TreeNode node = pRoot;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.empty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            if (!s.empty()) {
                node = s.pop();
                if(k==1)
                return node;
                else k--;
                node = node.right;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int [] data = {5,7,6,9,11,10,8};
        System.out.println(VerifySquenceOfBST(data));
    }

}

// Definition for a binary tree node.
class TreeNode {
    int val=0;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
