import java.util.*;

//Approach 1 Brute Force
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int countNonZero = 0;
        int ans = 0;

        for (int num : nums) {
            if (num != 0) {
                countNonZero++;
            }
        }

        if (countNonZero == n) {
            return 2 * n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (solve(nums.clone(), i, countNonZero, 1)) {
                    ans++;
                }

                if (solve(nums.clone(), i, countNonZero, -1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public boolean solve(int nums[], int index, int countNonZero, int direction) {
        while (countNonZero > 0 && index >= 0 && index < nums.length) {
            if (nums[index] > 0) {
                nums[index]--;
                direction *= -1;
                if (nums[index] == 0) {
                    countNonZero--;
                }
            }

            index += direction;
        }

        System.out.println(countNonZero);

        return countNonZero == 0;
    }
}

// Approach 2 Using Prefix and Suffix Sum Arrays O(n) time ans O(n) space
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int left[] = new int[n];
        int right[] = new int[n];
        int countNonZero = (nums[0] == 0 ? 0 : 1);
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (nums[i] != 0) {
                countNonZero++;
            }

            left[i] = left[i - 1] + nums[i];
            right[n - i - 1] = right[n - i] + nums[n - i - 1];
        }

        if (countNonZero == 0) {
            return 2 * n;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int leftSum = (i == 0 ? 0 : left[i - 1]);
                int rightSum = (i == n - 1 ? 0 : right[i + 1]);

                if (leftSum == rightSum) {
                    ans += 2;
                } else if (leftSum - rightSum == 1) {
                    ans++;
                } else if (rightSum - leftSum == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

// Approach 3 With O(1) SPace
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        int countNonZero = 0;

        for (int num : nums) {
            if (num != 0) {
                countNonZero++;
            }

            totalSum += num;
        }

        if (countNonZero == 0) {
            return 2 * n;
        }

        int ans = 0;
        int cumSum = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int leftSum = cumSum;
                int rightSum = totalSum - cumSum;

                if (leftSum == rightSum) {
                    ans += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    ans++;
                }
            } else {
                cumSum += nums[i];
            }
        }

        return ans;
    }
}