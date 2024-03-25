import java.util.*;

public class findDuplicateNumber {
    public static int findDuplicate(int nums[]) {
        // using set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // using constant space
    public static int findDuplicate2(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            if (nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 4, 2, 2 }; // range of integers[1,n] and size[n+1]
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate2(nums));
    }
}
