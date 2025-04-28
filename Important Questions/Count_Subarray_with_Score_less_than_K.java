public class Count_Subarray_with_Score_less_than_K {

    // Sliding Window
    public static long countSubarrays(int nums[], int k) {
        long count = 0;
        long sum = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            sum += nums[j];

            while (i <= j && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);

            j++;
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 4, 3, 5 };
        int k = 10;

        System.out.println(countSubarrays(nums, k));
    }
}
