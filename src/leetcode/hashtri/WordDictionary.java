package leetcode.hashtri;

/**
 * Created by mazhi on 2017/4/25.
 */
public class WordDictionary {
    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                ws.children[c - 'a'] = new TrieNode(c);
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        if (word.length() == 0) return true;
        return searchHelper(ws, word);
    }

    public boolean searchHelper(TrieNode node, String word) {
        if (word.length() == 0) return node.isWord;
        char c = word.charAt(0);
        if (c == '.') {
            int i = 0;
            while (i < node.children.length) {
                if (node.children[i] != null) {
                    if (searchHelper(node.children[i], word.substring(1))) {
                        return true;
                    }
                }
                i++;
            }
        } else {
            if (node.children[c - 'a'] == null) return false;
            else return searchHelper(node.children[c - 'a'], word.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));

    }
}
//class TrieNode {
//    public char val;
//    public boolean isWord;
//    public TrieNode[] children = new TrieNode[26];
//    public TrieNode() {}
//    TrieNode(char c){
//        TrieNode node = new TrieNode();
//        node.val = c;
//    }
//}
