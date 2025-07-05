import java.util.*;

public class Max_Score_From_Subarray_Mins {

    // using Deque O(n)
    public static int maxSum(int nums[]) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekFirst()] >= nums[i]) {
                int mid = deque.pollFirst();
                if (!deque.isEmpty()) {
                    int left = deque.peekFirst();
                    int score = nums[mid] + Math.min(nums[i], nums[left]);
                    maxScore = Math.max(maxScore, score);
                }
            }

            deque.offerFirst(i);
        }

        for (int i = 0; i < n - 1; i++) {
            maxScore = Math.max(maxScore, nums[i] + nums[i + 1]);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 3, 5, 1 };

        System.out.println(maxSum(nums));
    }
}
