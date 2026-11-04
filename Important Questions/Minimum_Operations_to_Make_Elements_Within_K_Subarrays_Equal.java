class Solution {
    private static class DualHeap {

        PriorityQueue<Integer> left = new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        PriorityQueue<Integer> right = new PriorityQueue<>();
        Map<Integer, Integer> delayed = new HashMap<>();
        int leftSize = 0,
            rightSize = 0;
        long sumL = 0,
            sumR = 0;

        void prune(PriorityQueue<Integer> heap) {
            while (
                !heap.isEmpty() && delayed.getOrDefault(heap.peek(), 0) > 0
            ) {
                int num = heap.poll();
                delayed.put(num, delayed.get(num) - 1);
            }
        }

        void balance() {
            if (leftSize > rightSize + 1) {
                int num = left.poll();
                right.offer(num);
                sumR += num;
                sumL -= num;
                ++rightSize;
                --leftSize;
                prune(left);
            } else if (rightSize > leftSize) {
                int num = right.poll();
                left.offer(num);
                sumL += num;
                sumR -= num;
                ++leftSize;
                --rightSize;
                prune(right);
            }
        }

        void add(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
                ++leftSize;
                sumL += num;
            } else {
                right.offer(num);
                ++rightSize;
                sumR += num;
            }
            balance();
        }

        void remove(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= left.peek()) {
                --leftSize;
                sumL -= num;
                if (num == left.peek()) {
                    prune(left);
                }
            } else {
                --rightSize;
                sumR -= num;
                if (num == right.peek()) {
                    prune(right);
                }
            }
            balance();
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        DualHeap heaps = new DualHeap();
        long[] ops = new long[n];
        for (int i = 0; i < n; ++i) {
            heaps.add(nums[i]);
            if (i >= x) {
                heaps.remove(nums[i - x]);
            }
            if (i >= x - 1) {
                long mid = heaps.left.peek();
                ops[i] =
                    heaps.sumR -
                    heaps.sumL +
                    mid * (heaps.leftSize - heaps.rightSize);
            }
        }

        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int j = 1; j <= k; ++j) {
            if (j == 1) {
                dp[x - 1][j] = ops[x - 1];
            } else {
                dp[j * x - 1][j] = dp[(j - 1) * x - 1][j - 1] + ops[j * x - 1];
            }
        }
        for (int j = 1; j <= k; ++j) {
            for (int i = j * x; i < n; ++i) {
                dp[i][j] = Math.min(dp[i - x][j - 1] + ops[i], dp[i - 1][j]);
            }
        }
        return dp[n - 1][k];
    }
}
