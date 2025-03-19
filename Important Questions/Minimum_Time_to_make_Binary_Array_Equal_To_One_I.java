import java.util.*;

//Same Question in Leetcode  995
public class Minimum_Time_to_make_Binary_Array_Equal_To_One_I {

    // Brute Force T.C= O(N*3)
    public static int minOperations(int[] nums) {
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
    public static int minOperations2(int nums[]) {
        int n = nums.length;
        int k = 3;
        boolean isFlipped[] = new boolean[n];
        int flippedCountForI = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && isFlipped[i - k]) {
                flippedCountForI--;
            }

            if (flippedCountForI % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }

                flippedCountForI++;
                result++;
                isFlipped[i] = true;
            }
        }

        return result;
    }

    // Approach 3 Using O(k) Space
    public static int minOperations4(int[] nums, int k) {
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
        int nums[] = { 0, 1, 1, 1, 0, 0 };
        int nums2[] = { 0, 1, 1, 1, 0, 0 };

        System.out.println(minOperations(nums));
        System.out.println(minOperations2(nums2));
    }
}
