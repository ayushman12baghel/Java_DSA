class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count;
    }

    public ArrayList<String> findPrefixes(ArrayList<String> arr) {
        TrieNode root = new TrieNode();

        for (String s : arr) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (node.child[i] == null)
                    node.child[i] = new TrieNode();
                node = node.child[i];
                node.count++;
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String s : arr) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for (char c : s.toCharArray()) {
                prefix.append(c);
                node = node.child[c - 'a'];
                if (node.count == 1)
                    break;
            }

            ans.add(prefix.toString());
        }

        return ans;
    }
}
