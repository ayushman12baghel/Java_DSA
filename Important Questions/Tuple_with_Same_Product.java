import java.util.*;

public class Tuple_with_Same_Product {

    // O(n3)
    public static int tupleSameProduct(int nums[]) {
        int n = nums.length;
        int count = 0;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                int product = nums[i] * nums[j];
                Set<Integer> set = new HashSet<>();

                for (int k = i + 1; k < j; k++) {
                    if (product % nums[k] == 0) {
                        int last = product / nums[k];
                        if (set.contains(last)) {
                            count++;
                        }

                        set.add(nums[k]);
                    }
                }
            }
        }

        return count * 8;
    }

    // O(n2)
    public static int tupleSameProduct2(int nums[]) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        for (int num : map.values()) {
            count += (num * (num - 1)) / 2;
        }

        return count * 8;
    }

    // O(n2)
    public static int tupleSameProduct3(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                int freq = map.getOrDefault(product, 0);
                count += freq;

                map.put(product, freq + 1);
            }
        }

        return count * 8;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 4, 5, 10 };

        System.out.println(tupleSameProduct(nums));
        System.out.println(tupleSameProduct2(nums));
        System.out.println(tupleSameProduct3(nums));
    }
}
