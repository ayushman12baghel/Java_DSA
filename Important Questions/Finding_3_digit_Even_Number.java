import java.util.*;

public class Finding_3_digit_Even_Number {

    // Approach 1 Using BruteForce
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    int number = (digits[i] * 100) + (digits[j] * 10) + digits[k];

                    if (number >= 100 && number % 2 == 0) {
                        set.add(number);
                    }
                }
            }
        }

        int ans[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            ans[i++] = num;
        }

        Arrays.sort(ans);

        return ans;
    }

    // Approach 2 O(1)
    public static int[] findEvenNumbers2(int[] digits) {
        int freq[] = new int[10];
        Set<Integer> set = new HashSet<>();

        for (int num : digits) {
            freq[num]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) {
                continue;
            }
            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) {
                    continue;
                }
                freq[j]--;

                for (int k = 0; k <= 8; k += 2) {
                    if (freq[k] == 0) {
                        continue;
                    }
                    freq[k]--;

                    int number = i * 100 + j * 10 + k;
                    set.add(number);
                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }

        int ans[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            ans[i++] = num;
        }

        Arrays.sort(ans);

        return ans;
    }

    public static void main(String args[]) {
        int digits[] = { 2, 1, 3, 0 };
        int ans1[] = findEvenNumbers(digits);
    }
}
