import java.util.*;

public class Most_Beautiful_Item_for_each_Query {

    public static int binarySearch(int items[][], int query) {
        int left = 0;
        int right = items.length - 1;
        int maxBeauty = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] > query) {
                right = mid - 1;
            } else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }

        return maxBeauty;
    }

    public static int[] maxBeauties(int items[][], int queries[]) {
        int result[] = new int[queries.length];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxBeauty = items[0][1];

        for (int i = 1; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(items, queries[i]);
        }

        return result;
    }

    public static void main(String args[]) {
        int items[][] = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        int queries[] = { 1, 2, 3, 4, 5, 6 };

        int ans[] = maxBeauties(items, queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
