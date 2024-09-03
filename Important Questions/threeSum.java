import java.util.*;

public class threeSum {

    public static List<List<Integer>> three_Sum(int nums[]) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String args[]) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> sum = three_Sum(nums);
        for (List<Integer> num : sum) {
            System.out.println(num);
        }
    }
}
