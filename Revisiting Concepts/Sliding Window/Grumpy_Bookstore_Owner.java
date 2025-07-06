import java.util.*;

public class Grumpy_Bookstore_Owner {

    // Sliding Window
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int currentUnsatisfied = 0;
        int maxUnsatisfied = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentUnsatisfied += customers[i];
            }
        }
        maxUnsatisfied = currentUnsatisfied;
        int i = 0;
        int j = minutes;

        while (j < n) {
            currentUnsatisfied += (grumpy[j] * customers[j]);
            currentUnsatisfied -= (grumpy[i] * customers[i]);

            maxUnsatisfied = Math.max(maxUnsatisfied, currentUnsatisfied);
            j++;
            i++;
        }

        int total = maxUnsatisfied;

        for (i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int customers[] = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int grumpy[] = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}
