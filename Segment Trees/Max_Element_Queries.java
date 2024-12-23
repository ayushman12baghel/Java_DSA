import java.util.*;

public class Max_Element_Queries {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildSt(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildSt(arr, 2 * i + 1, start, mid);
        buildSt(arr, 2 * i + 2, mid + 1, end);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);

        return;
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);

            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int index, int value) {
        if (index > sj || index < si) {
            return;
        }
        if (si == sj) {
            tree[i] = value;
        }
        if (si != sj) {
            tree[i] = Math.max(tree[i], value);
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, index, value);
            updateUtil(2 * i + 2, mid + 1, sj, index, value);
        }
    }

    public static void update(int arr[], int index, int value) {
        int n = arr.length;
        arr[index] = value;
        updateUtil(0, 0, n - 1, index, value);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildSt(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 8);
        System.out.println(getMax(arr, 2, 5));
    }
}
