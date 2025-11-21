import java.util.*;

//Greedy Approach O(n)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int count[] = new int[26];

        for (char c : name.toCharArray()) {
            count[c - 'a']--;
        }

        for (char c : typed.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }

        int left = 0;
        int right = 0;

        while (left < name.length() && right < typed.length()) {
            if (name.charAt(left) == typed.charAt(right)) {
                left++;
                right++;
            } else if (right > 0 && typed.charAt(right - 1) == typed.charAt(right)) {
                right++;
            } else {
                return false;
            }
        }

        if (left != name.length()) {
            return false;
        }

        char c = name.charAt(left - 1);
        while (right < typed.length()) {
            if (typed.charAt(right) != c) {
                return false;
            }
            right++;
        }

        return true;
    }
}