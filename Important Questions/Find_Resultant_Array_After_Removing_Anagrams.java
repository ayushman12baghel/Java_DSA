import java.util.*;

//O(n*mlogm)
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (ans.isEmpty()) {
                ans.add(words[i]);
                continue;
            }

            if (areAnagrams(ans.get(ans.size() - 1), words[i])) {
                continue;
            }

            ans.add(words[i]);
        }

        return ans;
    }

    public boolean areAnagrams(String word1, String word2) {
        char temp1[] = word1.toCharArray();
        char temp2[] = word2.toCharArray();

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        return Arrays.equals(temp1, temp2);
    }
}

// Approach 2 -> O(n*m)
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (ans.isEmpty()) {
                ans.add(words[i]);
                continue;
            }

            if (areAnagrams(ans.get(ans.size() - 1), words[i])) {
                continue;
            }

            ans.add(words[i]);
        }

        return ans;
    }

    public boolean areAnagrams(String word1, String word2) {
        int temp1[] = new int[26];
        int temp2[] = new int[26];

        for (char c : word1.toCharArray()) {
            temp1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            temp2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (temp1[i] != temp2[i]) {
                return false;
            }
        }

        return true;
    }
}