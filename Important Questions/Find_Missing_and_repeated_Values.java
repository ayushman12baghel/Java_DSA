import java.util.*;

public class Find_Missing_and_repeated_Values {

    // Approach: 1 Using Set O(n^2) time complexity and O(n) space complexity
    public static int[] findMissingAndRepeatedValues(int grid[][]) {
        Set<Integer> set = new HashSet<>();
        int ans[] = new int[2];

        for (int nums[] : grid) {
            for (int num : nums) {
                if (set.contains(num)) {
                    ans[0] = num;
                }

                set.add(num);
            }
        }

        for (int i = 1; i < set.size() * set.size(); i++) {
            if (!set.contains(i)) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

    // Approach: 2 Using Maths O(n^2) time complexity and O(1) space complexity
    public static int[] findMissingAndRepeatedValues2(int[][] grid) {
        int m = grid.length;
        int n = m * m;
        int ans[] = new int[2];
        long gridSum = ((long) n * (n + 1)) / 2;
        long gridSqSum = ((long) n * (n + 1) * (2 * n + 1)) / 6;

        long calcSum = 0;
        long calcSquare = 0;

        for (int nums[] : grid) {
            for (int num : nums) {
                calcSum += num;
                calcSquare += ((long) num * num);
            }
        }

        long sumDiff = gridSum - calcSum;
        long sqDiff = gridSqSum - calcSquare;

        ans[1] = (int) (((sqDiff / sumDiff) + sumDiff) / 2);
        ans[0] = (int) (((sqDiff / sumDiff) - sumDiff) / 2);

        return ans;
    }

    public static void main(String args[]) {
        int grid[][] = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };

        int ans[] = findMissingAndRepeatedValues(grid);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int ans2[] = findMissingAndRepeatedValues2(grid);

        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
