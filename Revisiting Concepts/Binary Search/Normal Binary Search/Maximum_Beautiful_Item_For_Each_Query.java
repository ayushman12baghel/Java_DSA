import java.util.*;

public class Maximum_Beautiful_Item_For_Each_Query {

    // Binary Search O(nlogn)
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxBeauty = items[0][1];
        for (int i = 1; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        int ans[] = new int[queries.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = binarySearch(items, queries[i]);
        }

        return ans;
    }

    public static int binarySearch(int items[][], int target) {
        int left = 0;
        int right = items.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (items[mid][0] <= target) {
                result = items[mid][1];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int items[][] = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } }, queries[] = { 1, 2, 3, 4, 5, 6 };
        int ans[] = maximumBeauty(items, queries);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
