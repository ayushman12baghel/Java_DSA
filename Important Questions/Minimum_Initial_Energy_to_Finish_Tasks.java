import java.util.*;

//Approach Using Binary Search O(nlogn)
class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;

        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int left = tasks[0][1];
        int right = 0;

        for (int task[] : tasks) {
            right += task[1];
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(tasks, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int tasks[][], int energy) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][1] > energy) {
                return false;
            }

            energy -= tasks[i][0];
        }

        return energy >= 0;
    }
}