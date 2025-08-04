import java.util.*;

public class Maximum_Points_You_Can_Obtain_From_Cards {

    // Sliding Window O(n)
    public static int maxScore(int cardPoints[], int k) {
        int n = cardPoints.length;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];

            if (i < n - k) {
                sum += cardPoints[i];
            }
        }

        int minSum = sum;
        int j = n - k;
        int i = 0;

        while (j < n) {
            sum += cardPoints[j];
            sum -= cardPoints[i];
            i++;
            minSum = Math.min(sum, minSum);

            j++;
        }

        return total - minSum;
    }

    public static void main(String[] args) {
        int cardPoints[] = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;

        System.out.println(maxScore(cardPoints, k));
    }
}
