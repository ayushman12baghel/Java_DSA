import java.util.Arrays;

public class Find_Value_of_Partition {

    public static int findValueOfPartition(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 2, 4 };

        System.out.println(findValueOfPartition(nums));
    }
}
