import java.util.*;

//Slower for more queries 
class NumArray {
    int temp[];

    public NumArray(int[] nums) {
        temp = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += temp[i];
        }

        return sum;
    }
}

// Faster
class NumArray {
    int temp[];

    public NumArray(int[] nums) {
        temp = new int[nums.length];
        temp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return temp[right];
        }

        return temp[right] - temp[left - 1];
    }
}