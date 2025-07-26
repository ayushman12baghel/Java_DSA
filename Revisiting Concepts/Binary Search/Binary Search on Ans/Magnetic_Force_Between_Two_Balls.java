import java.util.*;

public class Magnetic_Force_Between_Two_Balls {

    // Binary Search on Ans
    public static int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 0;
        int right = position[n - 1];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int position[], int m, int mid) {
        int count = 1;
        int j = 0;

        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[j] >= mid) {
                count++;
                j = i;
            }
        }

        return count >= m;
    }

    public static void main(String[] args) {
        int position[] = { 1, 2, 3, 4, 7 };
        int m = 3;

        System.out.println(maxDistance(position, m));
    }
}
