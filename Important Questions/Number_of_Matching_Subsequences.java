import java.util.*;

public class Number_of_Matching_Subsequences {

    // Approach 1 Brute Force Two - Pointer
    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;

        for (String word : words) {
            if (isSubsequence(s, word)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isSubsequence(String str, String word) {
        int i = 0;
        int j = 0;

        while (i < str.length() && j < word.length()) {
            if (str.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == word.length();
    }

    // Approch 2 Using HashMap and BinarySearch O(n + W * L * log n)
    public static int numMatchingSubseq2(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }

        for (String word : words) {
            if (isSubsequence(word, map)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isSubsequence(String word, Map<Character, List<Integer>> map) {
        int index = -1;

        for (char c : word.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            List<Integer> positions = map.get(c);
            int nextPos = binarySearch(positions, index);

            if (nextPos == -1) {
                return false;
            }

            index = positions.get(nextPos);
        }

        return true;
    }

    public static int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abcde";
        String words[] = { "a", "bb", "acd", "ace" };

        System.out.println(numMatchingSubseq(str, words));
        System.out.println(numMatchingSubseq2(str, words));
    }
}
