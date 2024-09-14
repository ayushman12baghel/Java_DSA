import java.util.*;

public class Find_Kth_Largest_Element_in_Array {

    public static String kthLargest(String nums[], int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });

        return nums[nums.length - k];

    }

    public static String kthLargest2(String nums[], int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            }
            return Integer.compare(b.length(), a.length());
        });

        for (String num : nums) {
            pq.add(num);
        }

        while (k > 1) {
            pq.remove();
            k--;
        }

        return pq.remove();
    }

    public static void main(String args[]) {
        String nums[] = { "3", "6", "7", "10" };
        int k = 4;

        System.out.println(kthLargest(nums, k));

        System.out.println(kthLargest2(nums, k));
    }
}
