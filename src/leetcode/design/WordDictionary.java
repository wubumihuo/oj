package leetcode.design;

//import leetcode.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mazhi on 2016/12/29.
 */
public class WordDictionary {
    private TreeNode root;
    public WordDictionary(){
        root = new TreeNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TreeNode temp = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(!temp.map.containsKey(word.charAt(i)))
                temp.map.put(word.charAt(i), new TreeNode()); //添加
            temp = temp.map.get(word.charAt(i)); //转到孩子节点
            if(i == word.length() - 1) //末尾字符
                temp.isWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word.length()==0) return true;
        return backtracking(0,word.toCharArray(),root);
//        for(int i = 0 ; i < word.length() ; i++){
//            TreeNode next = temp.map.get(word.charAt(i));
//            if(next == null)
//                return false;
//            temp = next;
//        }
//        return temp.isWord;
    }

    //回溯方法
    private boolean backtracking(int index,char [] array,TreeNode node){
        if(index==array.length)  return node.isWord;
        TreeNode temp = node;
        for(int i=index;i<array.length;i++){
            if(array[i]=='.'){
                Iterator iter = temp.map.entrySet().iterator();
                i++;
                while(iter.hasNext()){
                    Map.Entry entry = (Map.Entry) iter.next();
                    if(backtracking(i,array,(TreeNode) entry.getValue())) return true;
                }
                return false;
            }
            else {
                TreeNode next = temp.map.get(array[i]);
                if(next == null) return false;
                else return backtracking(++i,array,next);
            }
        }
        return false;
    }

    public static void main(String [] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }
}

class TreeNode {
    // Initialize your data structure here.
    boolean isWord;
    HashMap<Character, TreeNode> map;
    public TreeNode() {
        map = new HashMap<Character, TreeNode>();
    }
}

