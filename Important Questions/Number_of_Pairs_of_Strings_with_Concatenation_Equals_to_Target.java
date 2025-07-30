import java.util.*;

public class Number_of_Pairs_of_Strings_with_Concatenation_Equals_to_Target {

    // Approach 1 Brute Force O(n^2*k)
    public static int numOfPairs(String[] nums, String target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimised Approach Using HashMap O(n*k)
    public static int numOfPairs2(String[] nums, String target) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (String num : nums) {
            if (target.startsWith(num)) {
                String suffix = target.substring(num.length());

                if (map.containsKey(suffix)) {
                    count += map.get(suffix);
                }

                if (num.equals(suffix)) {
                    count--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String nums[] = { "777", "7", "77", "77" }, target = "7777";

        System.out.println(numOfPairs(nums, target));
        System.out.println(numOfPairs2(nums, target));
    }
}
