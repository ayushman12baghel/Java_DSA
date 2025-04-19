import java.util.*;

public class Count_Pairs_Whose_sum_less_than_Target {

    // Brute Force O(n^2)
    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 2 Using Two Pointers and Sorting O(nlogn)
    public static int countPairs2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int temp[] = { -6, 2, 5, -2, -7, -1, 3 };
        int target = 2;
        List<Integer> nums = new ArrayList<>();

        for (int num : temp) {
            nums.add(num);
        }

        System.out.println(countPairs(nums, target));
        System.out.println(countPairs2(nums, target));
    }
}
