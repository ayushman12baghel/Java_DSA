import java.util.*;

//O(n)
class Solution {
    public boolean isProduct(int[] arr, long target) {

        HashSet<Long> set = new HashSet<>();

        for (int num : arr) {
            if (target == 0) {
                if (num == 0 || set.contains(0L)) {
                    return true;
                }
            } else {
                if (num != 0 && target % num == 0) {
                    long needed = target / num;

                    if (set.contains(needed)) {
                        return true;
                    }
                }
            }

            set.add((long) num);
        }

        return false;
    }
}