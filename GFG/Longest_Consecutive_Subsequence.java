import java.util.*;

//Approach 1 Using Set O(n)
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int currentLength = 1;

                while (set.contains(current + 1)) {
                    currentLength++;
                    current++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}

// Approach 2 Using Sorting O(nlogn)
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        // code here
        Arrays.sort(nums);
        int currentLength = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}