import java.util.*;

class TrieNode {
    TrieNode children[];
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
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
        }

        current.endOfWord = true;
    }

    public boolean search(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }

        return true;
    }
}

public class Count_Prefix_and_Suffix_Pairs_I {

    public static int countPrefixSuffixPairs2(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            Trie prefix = new Trie();
            Trie suffix = new Trie();

            prefix.insert(words[i]);
            String reversed = new StringBuilder(words[i]).reverse().toString();
            suffix.insert(reversed);

            for (int j = 0; j < i; j++) {
                if (words[i].length() < words[j].length()) {
                    continue;
                }
                String rev = new StringBuilder(words[j]).reverse().toString();

                if (prefix.search(words[j]) && suffix.search(rev)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countPrefixSuffixPairs(String words[]) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String str1 = words[i];
                String str2 = words[j];

                if (str1.length() > str2.length()) {
                    continue;
                }

                if (str2.startsWith(str1) && str2.endsWith(str1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        String words[] = { "a", "aba", "ababa", "aa" };

        System.out.println(countPrefixSuffixPairs(words));
        System.out.println(countPrefixSuffixPairs2(words));
    }
}
