public class Sum_of_SUbarray_Ranges {

    public static int subarrayRanges(int nums[]) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                ans += max - min;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };

        System.out.println(subarrayRanges(nums));
    }
}
