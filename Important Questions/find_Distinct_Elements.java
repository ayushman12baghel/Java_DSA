import java.util.*;

// User function Template for Java
class Solution {
    static int distinct(int matrix[][], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(matrix[0][i], 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                if (map.containsKey(val) && map.get(val) == i) {
                    map.put(val, i + 1);
                }
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                count++;
            }
        }

        return count;
    }
}