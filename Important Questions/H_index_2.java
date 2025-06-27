import java.util.*;

public class H_index_2 {

    // Brute Force O(n^2)
    public static int hIndex(int citations[]) {
        int n = citations.length;
        int h_index = 0;

        for (int h = 0; h <= n; h++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }

            if (count >= h) {
                h_index = h;
            }
        }

        return h_index;
    }

    // Optimised Binary Search on ans O(logn)
    public static int hIndex2(int citations[]) {
        int n = citations.length;
        int h_index = 0;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;

            if (citations[mid] >= h) {
                h_index = h;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return h_index;
    }

    public static void main(String args[]) {
        int citations[] = { 0, 1, 3, 5, 6 };

        System.out.println(hIndex(citations));
        System.out.println(hIndex2(citations));
    }
}
