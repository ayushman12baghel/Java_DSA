import java.util.*;

//Approach O(n)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n = s1.length();
        char nums1[] = s1.toCharArray();
        char nums2[] = s2.toCharArray();

        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                if (i + 2 >= n) {
                    return false;
                } else if (nums1[i + 2] != nums2[i]) {
                    return false;
                } else {
                    char temp = nums1[i];
                    nums1[i] = nums1[i + 2];
                    nums1[i + 2] = temp;
                }
            }
        }

        return true;
    }
}

// Approach 2 Optimal O(n)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n = s1.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                freq1[s1.charAt(i) - 'a']++;
                freq1[s2.charAt(i) - 'a']--;
            } else {
                freq2[s1.charAt(i) - 'a']++;
                freq2[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 || freq2[i] != 0) {
                return false;
            }
        }

        return true;
    }
}