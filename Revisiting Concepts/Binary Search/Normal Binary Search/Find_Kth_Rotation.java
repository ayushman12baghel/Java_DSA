import java.util.*;

public class Find_Kth_Rotation {

    public static int findKRotation(List<Integer> nums) {
        // Code here
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) > nums.get(right)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 2, 3, 4 };
        List<Integer> nums2 = new ArrayList<>();
        for (int num : nums) {
            nums2.add(num);
        }
        System.out.println(findKRotation(nums2));
    }
}
