import java.util.*;

public class Successful_Pairs_of_Spells_and_Potions {

    // Approach Using Binary Search O(spells.length*log(potions.length) +
    // potions.length*log(potions.length))
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int ans[] = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            ans[i] = potions.length - binarySearch(spells[i], potions, success);
        }

        return ans;
    }

    public static int binarySearch(int temp, int potions[], long success) {
        int left = 0;
        int right = potions.length - 1;
        int ans = potions.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) temp * potions[mid] >= success) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int spells[] = { 5, 1, 3 };
        int potions[] = { 1, 2, 3, 4, 5 };
        long success = 7;

        int ans[] = successfulPairs(spells, potions, success);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
