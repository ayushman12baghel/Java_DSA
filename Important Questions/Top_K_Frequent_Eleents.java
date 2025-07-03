import java.util.*;

public class Top_K_Frequent_Eleents {

    // Approach Using HashMap and then Sorting
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(map.entrySet());

        Collections.sort(entrySet, (a, b) -> b.getValue() - a.getValue());

        int ans[] = new int[k];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (k == 0) {
                break;
            }

            ans[i++] = entry.getKey();
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int ans[] = topKFrequent(nums, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
