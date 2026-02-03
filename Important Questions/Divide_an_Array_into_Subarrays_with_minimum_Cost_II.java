import java.util.*;

//Approach Using SLiding Window with TreeSet O(nlogk)
class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<int[]> window = new TreeSet<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        TreeSet<int[]> remaining = new TreeSet<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        long sum = 0;
        int i = 1;
        while (i < n && i - dist < 1) {
            sum += nums[i];
            int current[] = new int[] { nums[i], i };
            window.add(current);

            if (window.size() > k - 1) {
                int remove[] = window.last();
                sum -= remove[0];
                remaining.add(remove);
                window.remove(remove);
            }

            i++;
        }

        long result = Long.MAX_VALUE;

        while (i < n) {
            sum += nums[i];
            int current[] = new int[] { nums[i], i };
            window.add(current);

            if (window.size() > k - 1) {
                int remove[] = window.last();
                sum -= remove[0];
                remaining.add(remove);
                window.remove(remove);
            }

            result = Math.min(result, sum);

            int removeIndex = i - dist;
            int remove[] = new int[] { nums[removeIndex], removeIndex };

            if (window.contains(remove)) {
                sum -= nums[removeIndex];
                window.remove(remove);

                if (!remaining.isEmpty()) {
                    int temp[] = remaining.first();
                    remaining.remove(temp);
                    sum += temp[0];
                    window.add(temp);
                }
            } else {
                remaining.remove(remove);
            }

            i++;
        }

        return nums[0] + result;
    }
}