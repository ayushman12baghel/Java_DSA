import java.util.Arrays;

public class Minimum_Operations_to_Make_a_UniValued_Grid {

    public static int minOperations(int grid[][], int x) {
        int sorted[] = new int[grid.length * grid[0].length];

        int i = 0;
        for (int row[] : grid) {
            for (int num : row) {
                sorted[i++] = num;
            }
        }
        Arrays.sort(sorted);
        int result = 0;
        int target = sorted[sorted.length / 2];

        for (int num : sorted) {
            if (target % x != num % x) {
                return -1;
            }

            result += Math.abs(target - num) / x;
        }

        return result;
    }

    public static void main(String args[]) {
        int grid[][] = { { 2, 4 }, { 6, 8 } };
        int x = 2;

        System.out.println(minOperations(grid, x));
    }
}
