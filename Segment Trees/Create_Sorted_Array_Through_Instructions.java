import java.util.*;

class Solution {
    public int createSortedArray(int[] instructions) {
        int mod = 1000000007;
        int maxVal = 0;

        for (int num : instructions) {
            maxVal = Math.max(maxVal, num);
        }

        SegmentTree st = new SegmentTree(maxVal + 2);
        long cost = 0;

        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];
            int less = st.query(1, x - 1);
            int greater = i - st.query(1, x);

            cost += Math.min(less, greater);
            cost %= mod;

            st.update(x, 1);
        }

        return (int) cost;
    }

    class SegmentTree {
        int n;
        int tree[];

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        public void update(int index, int delta) {
            updateST(0, 0, n - 1, index, delta);
        }

        public void updateST(int i, int start, int end, int index, int delta) {
            if (end == start) {
                tree[i] += delta;
                return;
            }

            int mid = start + (end - start) / 2;
            if (mid >= index) {
                updateST(2 * i + 1, start, mid, index, delta);
            } else {
                updateST(2 * i + 2, mid + 1, end, index, delta);
            }

            tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        }

        public int query(int left, int right) {
            return queryST(0, 0, n - 1, left, right);
        }

        public int queryST(int i, int start, int end, int left, int right) {
            if (start > right || end < left) {
                return 0;
            } else if (start >= left && end <= right) {
                return tree[i];
            }

            int mid = start + (end - start) / 2;
            int leftSum = queryST(2 * i + 1, start, mid, left, right);
            int rightSum = queryST(2 * i + 2, mid + 1, end, left, right);

            return leftSum + rightSum;
        }
    }
}