import java.util.*;

public class Two_Sum {
    // brute force
    public static int[] twoSum1(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {};
    }

    public static int[] twoSum2(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        int x[] = twoSum1(nums, target);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        int y[] = twoSum2(nums, target);
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }
    }

}
