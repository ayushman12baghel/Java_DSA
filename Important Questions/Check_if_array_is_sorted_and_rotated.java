import java.util.*;

public class Check_if_array_is_sorted_and_rotated {

    public static boolean check(int nums[]) {
        int n = nums.length;
        int sorted[] = new int[n];

        for (int r = 0; r <= n; r++) {
            int index = 0;

            for (int i = r; i < n; i++) {
                sorted[index++] = nums[i];
            }

            for (int i = 0; i < r; i++) {
                sorted[index++] = nums[i];
            }

            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }
        }

        return false;
    }

    // Approach 2
    public static boolean check2(int[] nums) {
        int n = nums.length;
        int sorted[] = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        for (int r = 0; r < n; r++) {
            boolean isSorted = true;
            for (int i = 0; i < n; i++) {
                if (sorted[i] != nums[(i + r) % n]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                return true;
            }
        }

        return false;
    }

    // Approach 3
    public static boolean check3(int[] nums) {
        int n = nums.length;
        int peak = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }

        return peak <= 1;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 1, 2 };

        System.out.println(check(nums));
        System.out.println(check2(nums));
        System.out.println(check3(nums));
    }
}
