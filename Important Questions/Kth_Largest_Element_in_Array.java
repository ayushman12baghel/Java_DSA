import java.util.*;

public class Kth_Largest_Element_in_Array {

    public static int kthLargest(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int num : nums) {
            pq.add(num);
        }

        while (k != 1) {
            pq.remove();
            k--;
        }

        return pq.remove();
    }

    public static int kthLargest2(int nums[], int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String args[]) {
        int nums[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(kthLargest(nums, k));
        System.out.println(kthLargest2(nums, k));
    }
}
