import java.util.*;

public class Sum_Of_Mode {

    // Sliding Window + TreeMap
    // Overall a Good Question
    public static int sumOfModes(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;

        // Number -> Frequency
        Map<Integer, Integer> map = new HashMap<>();
        // Frequency , -Number
        TreeSet<int[]> set = new TreeSet<>(
                (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(new int[] { entry.getValue(), -entry.getKey() });
        }

        sum += -set.last()[1];

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            // Remove outGoing element
            int outFreq = map.get(out);
            set.remove(new int[] { outFreq, -out });

            if (outFreq == 1) {
                map.remove(out);
            } else {
                map.put(out, map.get(out) - 1);
                set.add(new int[] { outFreq - 1, -out });
            }

            // Add Incoming Element
            int inFreq = map.getOrDefault(in, 0);
            if (inFreq > 0) {
                set.remove(new int[] { inFreq, -in });
            }

            map.put(in, map.getOrDefault(in, 0) + 1);
            set.add(new int[] { inFreq + 1, -in });

            sum += -set.last()[1];
        }

        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 2, 5, 2, 4, 4 }, k = 3;

        System.out.println(sumOfModes(nums, k));
    }
}
