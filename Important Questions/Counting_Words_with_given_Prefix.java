import java.util.*;

class TrieNode {
    TrieNode children[];
    boolean endOfWord;
    int count;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
        this.count = 0;
        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
            current.count++;
        }

        current.endOfWord = true;
    }

    public int count(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return 0;
            }
            current = current.children[idx];
        }

        return current.count;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        return trie.count(pref);
    }
}

public class Counting_Words_with_given_Prefix {
    public static void main(String args[]) {
        String words[] = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        Solution solution = new Solution();
        System.out.println(solution.prefixCount(words, pref));
    }
}
