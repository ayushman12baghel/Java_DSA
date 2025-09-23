class NumArray {
    int n;
    int tree[];

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];
        buildST(nums, 0, 0, n - 1);
    }

    public void update(int index, int val) {
        updateST(0, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return queryST(0, 0, n - 1, left, right);
    }

    public int buildST(int nums[], int i, int start, int end) {
        if (start == end) {
            tree[i] = nums[start];
            return tree[i];
        }

        int mid = start + (end - start) / 2;
        buildST(nums, 2 * i + 1, start, mid);
        buildST(nums, 2 * i + 2, mid + 1, end);

        return tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public void updateST(int i, int start, int end, int index, int val) {
        if (start == end) {
            tree[i] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateST(2 * i + 1, start, mid, index, val);
        } else {
            updateST(2 * i + 2, mid + 1, end, index, val);
        }

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public int queryST(int i, int start, int end, int left, int right) {
        if (start > right || left > end) { // no overlap
            return 0;
        } else if (left <= start && end <= right) { // complete overlap
            return tree[i];
        }

        int mid = start + (end - start) / 2;
        int leftSum = queryST(2 * i + 1, start, mid, left, right);
        int rightSum = queryST(2 * i + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */