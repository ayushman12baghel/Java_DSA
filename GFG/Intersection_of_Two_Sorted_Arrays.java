import java.util.*;

// Approach 1 Brute Force Using Set and Sorting O(nlogn)
class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }

        for (int num : b) {
            if (set.contains(num)) {
                set2.add(num);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(set2);
        Collections.sort(ans);

        return ans;
    }
}

// Approach 2 Pointer O(n+m)
class Solution {
    ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (i > 0 && nums1[i - 1] == nums1[i]) {
                i++;
                continue;
            }

            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }
}