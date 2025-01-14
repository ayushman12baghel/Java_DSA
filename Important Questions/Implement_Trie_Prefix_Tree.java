public class Implement_Trie_Prefix_Tree {

    static class TrieNode {
        TrieNode children[];
        boolean endOfWord;

        TrieNode() {
            this.endOfWord = false;
            this.children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    static TrieNode root;

    public Trie() {
        this.root=new TreeNode();
    }

    public static void insert(String word) {
        TreeNode current = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TreeNode();
            }
            current = current.children[idx];
        }

        current.endOfWord = true;
    }

    public static boolean search(String word) {
        TreeNode current = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }

        return current.endOfWord;
    }

    public static boolean startsWith(String prefix) {
        TreeNode current = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }

        return true;
    }

    public static void main(String args[]) {

    }
}
