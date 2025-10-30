import java.util.*;

//Approach 1 O(n)
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int current = 0;
        int prev = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            current = target[i];

            if (current > prev) {
                result += (current - prev);
            }
            prev = current;
        }

        return result;
    }
}