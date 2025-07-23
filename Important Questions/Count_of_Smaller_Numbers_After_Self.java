import java.util.*;

public class Count_of_Smaller_Numbers_After_Self {

    // Approach 1 Using BinarySearch by putting to the correct index O(nlogn) and
    // worst O(n^2)
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = binarySearch(sorted, nums[i]);
            result.add(index);
            sorted.add(index, nums[i]);
        }

        Collections.reverse(result);

        return result;
    }

    public static int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 2, 6, 1 };

        System.out.println(countSmaller(nums));
    }
}
