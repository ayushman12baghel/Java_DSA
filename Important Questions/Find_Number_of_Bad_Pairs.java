import java.util.*;

public class Find_Number_of_Bad_Pairs {

    public static long countBadPairs(int nums[]) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i;
        }

        for (int j = 0; j < nums.length; j++) {
            int countOfj = map.getOrDefault(nums[j], 0);
            int totalPairs = j - countOfj;
            count = count + totalPairs;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        return count;
    }

    public static long countBadPairs2(int[] nums) {
        long count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            int diff = nums[j] - j;
            int goodPairs = map.getOrDefault(diff, 0);
            int totalPairs = j;
            count = count + (totalPairs - goodPairs);
            map.put(diff, goodPairs + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 1, 3, 3 };

        System.out.println(countBadPairs(nums));
        System.out.println(countBadPairs2(nums));
    }
}
