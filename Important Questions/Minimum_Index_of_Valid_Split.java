import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Index_of_Valid_Split {
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            map1.put(num, map1.getOrDefault(num, 0) + 1);
            map2.put(num, map2.get(num) - 1);

            int n1 = i + 1;
            int n2 = n - i - 1;

            if (map1.get(num) * 2 > n1 && map2.get(num) * 2 > n2) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(2);

        System.out.println(minimumIndex(nums));
    }
}
