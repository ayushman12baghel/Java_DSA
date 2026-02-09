import java.util.*;

// Approach 1 Brute Force O(n^2)
class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;

        int bestK = 0;
        int maxAns = 0;

        for (int k = 0; k < n; k++) {
            int score = 0;
            for (int i = 0; i < n; i++) {
                int rotateValue = nums[(i + k) % n];
                if (rotateValue <= i) {
                    score++;
                }
            }

            if (score > maxAns) {
                bestK = k;
                maxAns = score;
            }
        }

        return bestK;
    }
}

// Approach 2 Using Difference Array O(n)
class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;

        int diff[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int v = nums[i];

            if (v <= i) {
                diff[0]++;
                diff[i - v + 1]--;

                diff[i + 1]++;
                diff[n]--;
            } else {
                diff[i + 1]++;
                diff[i + n - v + 1]--;
            }
        }

        int maxScore = -1;
        int bestK = 0;
        int currentScore = 0;

        for (int k = 0; k < n; k++) {
            currentScore += diff[k];

            if (maxScore < currentScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }

        return bestK;
    }
}