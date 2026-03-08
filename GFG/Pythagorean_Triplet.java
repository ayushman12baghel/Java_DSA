import java.util.*;

//Approach Using Two Pointers and Sorting O(n^2) T.L.E
class Solution {
    boolean pythagoreanTriplet(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        for (int i = n - 1; i >= 2; i--) {
            int target = nums[i];
            int left = 0;
            int right = i - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return false;
    }
}

// Approach 2 Checking all Possible elements O(maxElement^2)
class Solution {
    boolean pythagoreanTriplet(int[] nums) {
        int maxElement = nums[0];

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        boolean visited[] = new boolean[maxElement + 1];

        for (int num : nums) {
            visited[num] = true;
        }

        for (int a = 1; a <= maxElement; a++) {
            if (!visited[a]) {
                continue;
            }

            for (int b = a + 1; b <= maxElement; b++) {
                if (!visited[b]) {
                    continue;
                }

                int cSquare = a * a + b * b;

                int c = (int) Math.sqrt(cSquare);

                if (c * c == cSquare && c <= maxElement && visited[c]) {
                    return true;
                }
            }
        }

        return false;
    }
}