public class Count_Hills_and_Valleys_in_Array {

    public static int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int count = 0;

        while (j + 1 < n) {
            if ((nums[i] < nums[j] && nums[j] > nums[j + 1]) || nums[i] > nums[j] && nums[j] < nums[j + 1]) {
                count++;
                i = j;
            }

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 1, 1, 6, 5 };
        System.out.println(countHillValley(nums));
    }
}
