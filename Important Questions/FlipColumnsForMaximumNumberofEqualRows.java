import java.util.*;

public class FlipColumnsForMaximumNumberofEqualRows {

    public static int maxEqualRowsAfterFlips(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxRows = Integer.MIN_VALUE;

        for (int nums[] : matrix) {
            int inverted[] = new int[m];

            for (int i = 0; i < m; i++) {
                inverted[i] = nums[i] == 0 ? 1 : 0;
            }
            int count = 0;

            for (int row[] : matrix) {
                if (Arrays.equals(row, nums) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    public static int maxEqualRowsAfterFlips2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int nums[] : matrix) {
            StringBuilder sb = new StringBuilder();

            int first = nums[0];
            for (int col = 0; col < m; col++) {
                sb.append(nums[col] == first ? 'T' : 'F');
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        for (int num : map.values()) {
            count = Math.max(count, num);
        }

        return count;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 0, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

        System.out.println(maxEqualRowsAfterFlips(matrix));
        System.out.println(maxEqualRowsAfterFlips2(matrix));
    }
}
