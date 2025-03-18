public class Longest_Nice_Subarray {

    // Approach 1 Using Brute Force O(n^3)
    public static int longestNiceSubarray(int nums[]) {
        int length = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isNice(nums, i, j)) {
                    length = Math.max(length, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return length;
    }

    public static boolean isNice(int nums[], int i, int j) {
        int bitmask = nums[i];

        for (int k = i + 1; k <= j; k++) {
            if ((bitmask & nums[k]) != 0) {
                return false;
            }

            bitmask |= nums[k];
        }

        return true;
    }

    // Approach 2 Somewhat Optimised O(n^2(logn))
    public static int longestNiceSubarray2(int[] nums) {
        int left = 0;
        int right = nums.length;
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isNice(nums, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isNice(int nums[], int mid) {
        for (int i = 0; i <= nums.length - mid; i++) {
            int bitmask = nums[i];
            boolean isNice = true;

            for (int j = i + 1; j < i + mid; j++) {
                if ((bitmask & nums[j]) != 0) {
                    isNice = false;
                    break;
                }

                bitmask |= nums[j];
            }

            if (isNice) {
                return true;
            }
        }

        return false;
    }

    // Approach 3 Optimised Brute Force O(N^2)
    public static int longestNiceSubarray3(int[] nums) {
        int length = 1;

        for (int i = 0; i < nums.length; i++) {
            int bitmask = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if ((bitmask & nums[j]) != 0) {
                    break;
                }

                length = Math.max(length, j - i + 1);
                bitmask |= nums[j];
            }
        }

        return length;
    }

    // Approach 4 Using Sliding WIndow Algorithm O(N)
    public static int longestNiceSubarray4(int nums[]) {
        int length = 1;
        int bitmask = nums[0];
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if ((bitmask & nums[right]) != 0) {
                while ((bitmask & nums[right]) != 0) {
                    bitmask ^= nums[left];
                    left++;
                }
            }

            bitmask |= nums[right];
            length = Math.max(length, right - left + 1);
            right++;
        }

        return length;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 8, 48, 10 };
        System.out.println(longestNiceSubarray(nums));
        System.out.println(longestNiceSubarray2(nums));
        System.out.println(longestNiceSubarray3(nums));
        System.out.println(longestNiceSubarray4(nums));
    }
}
