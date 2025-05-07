public class Build_Array_from_Permutation {

    // Approach 1
    public static int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    // Approach 2 Without extra space
    public static int[] buildArray2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }

        return nums;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 2, 1, 5, 3, 4 };

        int ans[] = buildArray(nums);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
