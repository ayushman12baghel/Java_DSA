import java.util.*;

public class Longes_Subarray_SUm_Equals_Zero {

    public static int longestLength(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        int firstIndex = -1;
        int lastIndex = -1;
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                int length = i - prevIndex;

                if (length > maxLength) {
                    firstIndex = prevIndex + 1;
                    lastIndex = i;
                    maxLength = length;
                }
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, -3 };

        System.out.println(longestLength(nums));
    }
}
