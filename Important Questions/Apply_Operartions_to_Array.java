public class Apply_Operartions_to_Array {
    // Approach 1:
    // T C: O(n) and S C: O(n) Using 2 pass
    public static int[] applyOperations(int[] nums) {
        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            ans[j++] = nums[i];
        }

        return ans;
    }

    // T C: O(n) and S C: O(n) Using 1 pass
    public static int[] applyOperations2(int[] nums) {
        int ans[] = new int[nums.length];
        int j = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                ans[j++] = nums[i];
            }
        }

        if (nums[nums.length - 1] != 0) {
            ans[j] = nums[nums.length - 1];
        }

        return ans;
    }

    // Approach 2 :
    // T C: O(n) and S C: O(1) Using 2 pass
    public static int[] applyOperations3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }

        return nums;
    }

    // T C: O(n) and S C: O(1) Using 1 pass
    public static int[] applyOperations4(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums.length && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                }
                j++;
            }
        }

        return nums;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 2, 1, 1, 0 };

        int ans[] = applyOperations(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        int ans2[] = applyOperations(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
