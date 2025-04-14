import java.util.*;

public class Count_Good_Triplets {

    // Approach 1 -> Brute Force
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }

                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[k] - arr[j]) > b || Math.abs(arr[i] - arr[k]) > c) {
                        continue;
                    }

                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 0, 1, 1, 9, 7 };
        int a = 7;
        int b = 2;
        int c = 3;

        System.out.println(countGoodTriplets(arr, a, b, c));
    }
}
