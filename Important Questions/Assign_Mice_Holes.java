import java.util.*;

//Greedy Approach O(nlogn)
class Solution {
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < mices.length; i++) {
            result = Math.max(result, Math.abs(mices[i] - holes[i]));
        }

        return result;
    }
};