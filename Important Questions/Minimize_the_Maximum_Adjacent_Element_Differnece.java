import java.util.*;

public class Minimize_the_Maximum_Adjacent_Element_Differnece {

    public static int minDifference(int[] nums) {
        int min_val = Integer.MAX_VALUE;
        int max_val = 0;
        int maxAbsDiff = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != -1 && nums[i + 1] != -1) {
                maxAbsDiff = Math.max(maxAbsDiff, Math.abs(nums[i] - nums[i + 1]));
            } else if (!(nums[i] == -1 && nums[i + 1] == -1)) {
                int value = Math.max(nums[i], nums[i + 1]);
                min_val = Math.min(min_val, value);
                max_val = Math.max(max_val, value);
            }
        }

        int left = maxAbsDiff;
        int right = max_val - min_val;
        int result = maxAbsDiff;

        while (left <= right) {
            int d = left + (right - left) / 2;
            int x = min_val + d;
            int y = max_val - d;

            if (check(nums, x, y, d)) {
                result = d;
                right = d - 1;
            } else {
                left = d + 1;
            }
        }

        return result;
    }

    public static boolean check(int nums[], int x, int y, int d) {
        int count = 0;
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                if (prev != 0 && Math.min(Math.abs(prev - x), Math.abs(prev - y)) > d) {
                    return false;
                }

                count++;
            } else {
                if (count > 0) {
                    int absMaxDiff;
                    if (prev != 0) {
                        absMaxDiff = Math.min(
                                Math.max(Math.abs(prev - x), Math.abs(nums[i] - x)),
                                Math.max(Math.abs(prev - y), Math.abs(nums[i] - y)));
                    } else {
                        absMaxDiff = Math.min(Math.abs(nums[i] - x), Math.abs(nums[i] - y));
                    }
                    boolean canMixXandY = (count >= 2 && Math.abs(x - y) <= d);

                    if (absMaxDiff > d && !canMixXandY) {
                        return false;
                    }
                }

                prev = nums[i];
                count = 0;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, -1, 10, 8 };

        System.out.println(minDifference(nums));
    }
}
