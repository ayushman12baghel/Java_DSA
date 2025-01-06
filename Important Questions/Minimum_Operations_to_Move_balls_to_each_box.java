import java.util.*;

public class Minimum_Operations_to_Move_balls_to_each_box {

    // Brute Force
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        List<Integer> list = new ArrayList<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                list.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int moves = 0;

            for (int j : list) {
                moves += Math.abs(i - j);
            }

            ans[i] = moves;
        }

        return ans;
    }

    // Optimal SOlution
    public static int[] minOperations2(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];

        int cumSum = 0;
        int cumValue = 0;

        // left
        for (int i = 0; i < n; i++) {
            ans[i] += cumSum;
            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumSum += cumValue;
        }

        cumSum = 0;
        cumValue = 0;

        // right
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += cumSum;
            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumSum += cumValue;
        }

        return ans;
    }

    public static void main(String args[]) {
        String boxes = "001011";

        int ans1[] = minOperations(boxes);
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + " ");
        }

        System.out.println();

        int ans2[] = minOperations2(boxes);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
