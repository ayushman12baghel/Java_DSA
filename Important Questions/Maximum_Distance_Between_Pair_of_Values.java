import java.util.*;

public class Maximum_Distance_Between_Pair_of_Values {

    // Greedy Two Pointer
    public static int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int maxDiff = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int nums1[] = { 55, 30, 5, 4, 2 };
        int nums2[] = { 100, 20, 10, 10, 5 };

        System.out.println(maxDistance(nums1, nums2));
    }
}
