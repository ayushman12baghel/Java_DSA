import java.util.*;

public class Count_Good_Tripplets_in_an_Array {

    // Segment Tree Approach
    public static long goodTriplets(int nums1[], int nums2[]) {
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        long segmentTree[] = new long[4 * n];
        updateSegmentTree(0, 0, n - 1, map.get(nums1[0]), segmentTree);
        long result = 0;

        for (int i = 1; i < n; i++) {
            int index = map.get(nums1[i]);
            long leftCommonCount = querySegmentTree(0, index, 0, 0, n - 1, segmentTree);
            long leftNotCommonCount = i - leftCommonCount;

            long elementAfterIndexNums2 = n - 1 - index;
            long rightCommonCount = elementAfterIndexNums2 - leftNotCommonCount;

            result += leftCommonCount * rightCommonCount;

            updateSegmentTree(0, 0, n - 1, index, segmentTree);
        }

        return result;
    }

    public static long querySegmentTree(int qs, int qe, int i, int l, int r, long segmentTree[]) {
        if (r < qs || l > qe) {
            return 0;
        } else if (l >= qs && r <= qe) {
            return segmentTree[i];
        } else {
            int mid = (l + r) / 2;
            long left = querySegmentTree(qs, qe, 2 * i + 1, l, mid, segmentTree);
            long right = querySegmentTree(qs, qe, 2 * i + 2, mid + 1, r, segmentTree);
            return left + right;
        }
    }

    public static void updateSegmentTree(int i, int l, int r, int index, long segmentTree[]) {
        if (l == r) {
            segmentTree[i] = 1;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            updateSegmentTree(2 * i + 1, l, mid, index, segmentTree);
        } else {
            updateSegmentTree(2 * i + 2, mid + 1, r, index, segmentTree);
        }

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public static void main(String args[]) {
        int nums1[] = { 4, 0, 1, 3, 2 };
        int nums2[] = { 4, 1, 0, 2, 3 };

        System.out.println(goodTriplets(nums1, nums2));
    }
}
