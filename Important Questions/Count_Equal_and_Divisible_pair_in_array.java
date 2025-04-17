import java.util.*;

public class Count_Equal_and_Divisible_pair_in_array {

    // Brute Force O(n^2)
    public static int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 2 Using Gcd O(n*log(n))
    public static int countPairs2(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> indicesMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indicesMap.putIfAbsent(nums[i], new ArrayList<>());
            indicesMap.get(nums[i]).add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= k; i++) {
            if (k % i == 0) {
                set.add(i);
                set.add(k / i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : indicesMap.entrySet()) {
            List<Integer> indices = entry.getValue();
            Map<Integer, Integer> factorsMap = new HashMap<>();

            for (int i : indices) {
                int gcd = gcd(i, k);
                int j = k / gcd;

                count += factorsMap.getOrDefault(j, 0);

                for (int f : set) {
                    if (i % f == 0) {
                        factorsMap.put(f, factorsMap.getOrDefault(f, 0) + 1);
                    }
                }
            }
        }

        return count;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 1, 2, 2, 2, 1, 3 };
        int k = 2;

        System.out.println(countPairs(nums, k));
        System.out.println(countPairs2(nums, k));
    }
}
