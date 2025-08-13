import java.util.*;

public class Tywins_War_Strategy {

    // Approach 1 Using Greedy + Sorting O(nlogn)
    public static int minSoldiers(int nums[], int k) {
        int n = nums.length;
        int required = (n + 1) / 2;
        int gotCount = 0;
        List<Integer> additions = new ArrayList<>();

        for (int num : nums) {
            if (num % k == 0) {
                gotCount++;
            } else {
                additions.add(k - (num % k));
            }
        }

        if (gotCount >= required) {
            return 0;
        }

        Collections.sort(additions);

        int addCount = 0;
        for (int addition : additions) {
            addCount += addition;
            gotCount++;

            if (gotCount >= required) {
                return addCount;
            }
        }

        return addCount;
    }

    // Approach 2 Using minHeap more Optimised
    public static int minSoldiers2(int[] nums, int k) {
        int n = nums.length;
        int requiredCount = (n + 1) / 2;
        int gotCount = 0;

        PriorityQueue<Integer> additions = new PriorityQueue<>();

        for (int num : nums) {
            if (num % k == 0) {
                gotCount++;
            } else {
                additions.offer(k - (num % k));
            }
        }

        if (gotCount >= requiredCount) {
            return 0;
        }

        int addedCount = 0;
        while (!additions.isEmpty()) {
            addedCount += additions.poll();
            gotCount++;

            if (gotCount >= requiredCount) {
                return addedCount;
            }
        }

        return addedCount;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 5, 6, 7, 9, 10 };
        int k = 4;

        System.out.println(minSoldiers(nums, k));
        System.out.println(minSoldiers2(nums, k));
    }
}
