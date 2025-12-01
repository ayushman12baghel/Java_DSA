import java.util.*;

//Brute Force O(n^2)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int currentGas = gas[i];
            int currentCost = cost[i];

            if (currentCost > currentGas) {
                continue;
            }

            int j = i + 1;
            j %= n;

            while (j != i) {
                currentGas += gas[j];
                currentCost += cost[j];

                if (currentCost > currentGas) {
                    break;
                }
                j = (j + 1) % n;
            }

            if (j == i) {
                return i;
            }
        }

        return -1;
    }
}

// Approach 2 Greedy O(n)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);
        }

        if (total < 0) {
            return -1;
        }

        total = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        return result;
    }
}