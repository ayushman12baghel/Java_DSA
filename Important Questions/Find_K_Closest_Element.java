import java.util.*;

public class Find_K_Closest_Element {

    public static List<Integer> findClosest(int nums[], int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (k > 0) {
                pq.add(num);
                k--;
            } else if (Math.abs(pq.peek() - x) > Math.abs(num - x)) {
                pq.remove();
                pq.add(num);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }

        return list;
    }

    // Approach 2 more Optimised

    public static List<Integer> findClosest2(int nums[], int k, int x) {
        int left = 0;
        int right = nums.length - 1;
        List<Integer> list = new ArrayList<>();

        while (right - left + 1 > k) {
            if (Math.abs(nums[right] - x) >= Math.abs(nums[left] - x)) {
                right--;
            } else {
                left++;
            }
        }

        for (int index = left; index <= right; index++) {
            list.add(nums[index]);
        }

        return list;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5 };
        int x = 3;
        int k = 4;

        List<Integer> list = findClosest(nums, k, x);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<Integer> list2 = findClosest2(nums, k, x);
        for (int num : list2) {
            System.out.print(num + " ");
        }
    }
}
