import java.util.*;

public class Max_Index_Range_Query {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildSt(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = start;
            return;
        }

        int mid = (start + end) / 2;
        buildSt(arr, 2 * i + 1, start, mid);
        buildSt(arr, 2 * i + 2, mid + 1, end);
        int leftMaxIndex = tree[2 * i + 1];
        int rightMaxIndex = tree[2 * i + 2];

        if (arr[leftMaxIndex] >= arr[rightMaxIndex]) {
            tree[i] = leftMaxIndex;
        } else {
            tree[i] = rightMaxIndex;
        }
    }

    public static int getMaxIndex(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxIndexUtil(arr, 0, 0, n - 1, qi, qj);
    }

    public static int getMaxIndexUtil(int arr[], int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) {
            return -1;
        }
        if (si >= qi && sj <= qj) {
            return tree[i];
        }
        int mid = (si + sj) / 2;
        int left = getMaxIndexUtil(arr, 2 * i + 1, si, mid, qi, qj);
        int right = getMaxIndexUtil(arr, 2 * i + 2, mid + 1, sj, qi, qj);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return (arr[left] >= arr[right]) ? left : right;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildSt(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getMaxIndex(arr, 2, 5));
    }
}
