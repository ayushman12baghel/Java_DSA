import java.util.*;

public class first_missing_positive {
    public static int FirstMissingPositive(int nums[]) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, -1, 1 };
        System.out.println(FirstMissingPositive(nums));
    }
}
