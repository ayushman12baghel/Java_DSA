import java.util.ArrayDeque;
import java.util.Deque;

public class Minimum_Number_of_k_consecutives_Flips {

    // Brute Force T.C= O(N*k) T.L.E
    public static int minKBitFlips2(int[] nums) {
        int k = 3;
        int n = nums.length;
        int count = 0;

        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] == 1) {
                continue;
            }

            for (int j = i; j < i + k; j++) {
                nums[j] = (nums[j] == 0 ? 1 : 0);
            }
            count++;
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return count;
    }

    // Approach 2 Using Array T.E = O(n)
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        boolean isFlipped[] = new boolean[n];
        int flippedCountForI = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k && isFlipped[i - k]) {
                flippedCountForI--;
            }

            if (flippedCountForI % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }

                flippedCountForI++;
                isFlipped[i] = true;
                result++;
            }
        }

        return result;
    }

    // Avoiding Extra Space by Doing Changes in nums only
    public static int minKBitFlips3(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int flippedCountForI = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] == -1) {
                flippedCountForI--;
            }

            if (flippedCountForI % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }

                flippedCountForI++;
                nums[i] = -1;
                result++;
            }
        }

        return result;
    }

    // Approach 3 Using Deque O(k) space
    public static int minKBitFlips4(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int flippedCountForI = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flippedCountForI -= deque.pollFirst();
            }

            if (flippedCountForI % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }

                flippedCountForI++;
                deque.addLast(1);
                result++;
            } else {
                deque.addLast(0);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 0, 0, 1, 0, 1, 1, 0 };
        int k = 3;

        System.out.println(minKBitFlips(nums, k));
    }
}
