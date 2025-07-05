import java.util.*;

public class Find_Lucky_Integer_in_an_Array {

    // Using HashMap O(n)
    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == value) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2, 3, 3, 3 };

        System.out.println(findLucky(nums));
    }
}
