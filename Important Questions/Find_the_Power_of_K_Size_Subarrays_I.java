public class Find_the_Power_of_K_Size_Subarrays_I {

    public static int[] resultsArray(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            boolean isIncreasing = true;
            boolean isConsecutive = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    isIncreasing = false;
                }
                if (nums[j] + 1 != nums[j + 1]) {
                    isConsecutive = false;
                }
            }
            if (isIncreasing && isConsecutive) {
                result[i] = nums[i + k - 1];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    // optimised beats 100%
    public static int[] resultsArray2(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];
        int count = 1;

        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count == k) {
            result[0] = nums[k - 1];
        } else {
            result[0] = -1;
        }

        int i = 1;
        int j = k;

        while (j < nums.length) {
            if (nums[j] == nums[j - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                result[i] = nums[j];
            } else {
                result[i] = -1;
            }
            i++;
            j++;
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;

        int ans[] = resultsArray(nums, k);
        int ans2[] = resultsArray2(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
