import java.util.*;

public class Alternating_Groups_II {

    // Approach 1 Using Brute Force O(n*k)
    public static int numberOfAlternatingGroups(int colors[], int k) {
        int n = colors.length;
        int N = n + k - 1;
        int ans[] = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            ans[i] = colors[i % n];
        }

        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int j = i + 1; j < i + k - 1; j++) {
                if (ans[j - 1] == ans[j] || ans[j] == ans[j + 1]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }

    // Approach 2 Using Sliding Window O(n+k)
    public static int numberOfAlternatingGroups2(int[] colors, int k) {
        int n = colors.length;
        int N = n + k - 1;
        int ans[] = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            ans[i] = colors[i % n];
        }

        int i = 0;
        int j = 1;
        while (j < N) {
            if (ans[j] == ans[j - 1]) {
                i = j;
                j++;
                continue;
            }
            if (j - i + 1 == k) {
                count++;
                i++;
            }

            j++;
        }

        return count;
    }

    // Approach 3 Using Two Passes O(n+k)
    public static int numberOfAlternatingGroups3(int[] colors, int k) {
        int length = 1;
        int count = 0;
        int prevColor = colors[0];

        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == prevColor) {
                length = 1;
                prevColor = colors[i];
                continue;
            }

            length++;
            prevColor = colors[i];

            if (length >= k) {
                count++;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            if (colors[i] == prevColor) {
                length = 1;
                prevColor = colors[i];
                continue;
            }

            length++;
            prevColor = colors[i];

            if (length >= k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int colors[] = { 0, 1, 0, 1, 0 };
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
        System.out.println(numberOfAlternatingGroups2(colors, k));
        System.out.println(numberOfAlternatingGroups3(colors, k));
    }
}
