import java.util.*;

public class BitWise_Xor_of_All_Pairings {

    public static int xorAllNums(int nums1[], int nums2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + nums2.length);
        }
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + nums1.length);
        }

        for (int num : map.keySet()) {
            if (map.get(num) % 2 != 0) {
                ans ^= num;
            }
        }

        return ans;
    }

    public static int xorAllNums2(int[] nums1, int[] nums2) {
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
            return 0;
        }

        int ans1 = 0;
        int ans2 = 0;

        if (nums1.length % 2 != 0) {
            for (int num : nums2) {
                ans1 ^= num;
            }
        }

        if (nums2.length % 2 != 0) {
            for (int num : nums1) {
                ans2 ^= num;
            }
        }

        return (ans1 ^ ans2);
    }

    public static void main(String args[]) {
        int nums1[] = { 2, 1, 3 };
        int nums2[] = { 10, 2, 5, 0 };

        System.out.println(xorAllNums(nums1, nums2));
        System.out.println(xorAllNums2(nums1, nums2));
    }
}
