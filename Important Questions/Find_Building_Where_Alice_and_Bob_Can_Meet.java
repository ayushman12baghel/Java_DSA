import java.util.*;

public class Find_Building_Where_Alice_and_Bob_Can_Meet {

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int tree[] = new int[4 * n];
        buildSt(tree, heights, 0, 0, n - 1);
        int ans[] = new int[queries.length];
        int i = 0;

        for (int query[] : queries) {
            int start = query[0];
            int end = query[1];
            int maxIndex = Math.max(start, end);
            int minIndex = Math.min(start, end);

            if (start == end) {
                ans[i++] = start;
                continue;
            } else if (heights[minIndex] < heights[maxIndex]) {
                ans[i++] = maxIndex;
                continue;
            }

            int left = maxIndex + 1;
            int right = n - 1;
            int result = Integer.MAX_VALUE;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int index = RMIQ(tree, heights, left, mid);
                if (heights[index] > Math.max(heights[start], heights[end])) {
                    result = Math.min(result, index);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans[i++] = (result == Integer.MAX_VALUE ? -1 : result);
        }

        return ans;
    }

    public static void buildSt(int tree[], int heights[], int i, int start, int end) {
        if (start == end) {
            tree[i] = start;
            return;
        }

        int mid = start + (end - start) / 2;
        buildSt(tree, heights, 2 * i + 1, start, mid);
        buildSt(tree, heights, 2 * i + 2, mid + 1, end);
        int leftMaxIndex = tree[2 * i + 1];
        int rightMaxIndex = tree[2 * i + 2];

        tree[i] = (heights[leftMaxIndex] >= heights[rightMaxIndex]) ? leftMaxIndex : rightMaxIndex;
    }

    public static int RMIQ(int tree[], int heights[], int qi, int qj) {
        int n = heights.length;
        return getMaxIndex(tree, heights, 0, 0, n - 1, qi, qj);
    }

    public static int getMaxIndex(int tree[], int heights[], int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) {
            return -1;
        }
        if (si >= qi && sj <= qj) {
            return tree[i];
        }

        int mid = si + (sj - si) / 2;
        int left = getMaxIndex(tree, heights, 2 * i + 1, si, mid, qi, qj);
        int right = getMaxIndex(tree, heights, 2 * i + 2, mid + 1, sj, qi, qj);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return (heights[left] >= heights[right] ? left : right);
    }

    public static void main(String args[]) {
        int heights[] = { 6, 4, 8, 5, 2, 7 };
        int queries[][] = { { 0, 1 }, { 0, 3 }, { 2, 4 }, { 3, 4 }, { 2, 2 } };

        int ans[] = leftmostBuildingQueries(heights, queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
