import java.util.*;

public class findAllDuplicates {
    // with constant space
    public static List findAllDuplicates(int nums[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] < 0) {
                list.add(Math.abs(ind + 1));
            }
            nums[ind] = -nums[ind];
        }
        return list;
    }

    public static List findAllDuplicates2(int nums[]) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                list.add(num);
            } else {
                set.add(num);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findAllDuplicates2(nums));
        System.out.println(findAllDuplicates(nums));
    }
}
