package leetcode.design;

import java.util.HashMap;

/**
 * 前缀树：所有含有公共前缀的字符串将挂在树中用一个节点下
 * Created by mazhi on 2016/12/29.
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    HashMap<Character, TrieNode> map;
    public TrieNode() {
        map = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] charray = word.toCharArray();
        TrieNode temp = root;
        for(int i = 0 ; i < charray.length ; i++){
            if(!temp.map.containsKey(charray[i]))
                temp.map.put(charray[i], new TrieNode()); //添加
            temp = temp.map.get(charray[i]); //转到孩子节点
            if(i == charray.length - 1) //末尾字符
                temp.isWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;

        for(int i = 0 ; i < word.length() ; i++){
            TrieNode next = temp.map.get(word.charAt(i));
            if(next == null)
                return false;
            temp = next;
        }
        return temp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for(int i = 0 ; i < prefix.length() ; i++){
            TrieNode next = temp.map.get(prefix.charAt(i));
            if(next == null)
                return false;
            temp = next;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");