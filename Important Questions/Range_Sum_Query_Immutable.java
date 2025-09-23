import java.util.*;

//Slower for more queries 
class NumArray {
    int temp[];

    public NumArray(int[] nums) {
        temp = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += temp[i];
        }

        return sum;
    }
}

// Faster
class NumArray {
    int temp[];

    public NumArray(int[] nums) {
        temp = new int[nums.length];
        temp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return temp[right];
        }

        return temp[right] - temp[left - 1];
    }
}

// Using Segment Trees
class SegmentTree {
    int tree[];
    int n;

    public SegmentTree(int nums[]) {
        n = nums.length;
        tree = new int[4 * n];

        buildST(nums, 0, 0, n - 1);
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

    public int query(int left, int right) {
        return queryST(0, 0, n - 1, left, right);
    }

    public int queryST(int i, int start, int end, int left, int right) {
        if (left > end || start > right) {
            return 0;
        } else if (start >= left && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start) / 2;
        int leftSum = queryST(2 * i + 1, start, mid, left, right);
        int rightSum = queryST(2 * i + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}

class NumArray {
    SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */