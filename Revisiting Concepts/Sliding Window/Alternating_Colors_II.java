import java.util.*;

public class Alternating_Colors_II {

    // Approach 1 Using Sliding Window
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n + k - 1;
        int i = 0;
        int j = 1;
        int ans = 0;

        while (j < N) {
            if (colors[(j - 1) % n] == colors[j % n]) {
                i = j;
                j++;
                continue;
            }

            if (j - i + 1 == k) {
                ans++;
                i++;
            }

            j++;
        }

        return ans;
    }

    // Approach 2 Greedy Approach
    public static int numberOfAlternatingGroups2(int colors[], int k) {
        int n = colors.length;
        int prevColor = colors[0];
        int N = n + k - 1;
        int j = 1;
        int ans = 0;
        int length = 1;

        while (j < N) {
            if (colors[j % n] == prevColor) {
                length = 1;
                j++;
                continue;
            }

            length++;

            if (length >= k) {
                ans++;
            }

            prevColor = colors[j % n];

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int colors[] = { 0, 1, 0, 0, 1, 0, 1 };
        int k = 6;

        System.out.println(numberOfAlternatingGroups(colors, k));
        System.out.println(numberOfAlternatingGroups2(colors, k));
    }
}
