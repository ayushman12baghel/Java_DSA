import java.util.*;

public class Partition_Array_Such_that_Maximum_Differnce_is_K {

    public static int partitionArray(int nums[], int k) {
        Arrays.sort(nums);
        int count = 1;
        int minValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - minValue > k) {
                count++;
                minValue = nums[i];
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 6, 1, 2, 5 };
        int k = 2;

        System.out.println(partitionArray(nums, k));
    }
}
