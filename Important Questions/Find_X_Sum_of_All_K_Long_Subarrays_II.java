import java.util.*;

//Approach Using TreeMap T.L.E
//O(n (logk + X))
class Pair implements Comparable<Pair> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair p) {
        if (p.value == this.value) {
            return p.key - this.key;
        }

        return p.value - this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pair)) {
            return false;
        }

        Pair p = (Pair) o;

        return this.key == p.key && this.value == p.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        long ans[] = new long[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Pair, Integer> tree = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            addNum(nums[i], map, tree);
        }

        ans[0] = getXSum(tree, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            removeNum(out, map, tree);
            addNum(nums[i], map, tree);

            ans[i - k + 1] = getXSum(tree, x);
        }

        return ans;
    }

    public void addNum(int num, Map<Integer, Integer> map, TreeMap<Pair, Integer> tree) {
        int out = map.getOrDefault(num, 0);
        if (out > 0) {
            tree.remove(new Pair(num, out));
        }

        map.put(num, out + 1);
        tree.put(new Pair(num, out + 1), 1);
    }

    public void removeNum(int num, Map<Integer, Integer> map, TreeMap<Pair, Integer> tree) {
        int out = map.getOrDefault(num, 0);
        tree.remove(new Pair(num, out));
        if (out == 1) {
            map.remove(num);
        } else {
            map.put(num, out - 1);
            tree.put(new Pair(num, out - 1), 1);
        }
    }

    public long getXSum(TreeMap<Pair, Integer> tree, int x) {
        long sum = 0;
        int count = 0;

        for (Pair p : tree.keySet()) {
            if (count == x) {
                return sum;
            }

            sum += ((long) p.key * p.value);
            count++;
        }

        return sum;
    }
}

// Approach Using 2 TreeMap So that We dont have to look for X sum again
// O(n log k); Excepted
class Pair implements Comparable<Pair> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.value == p.value) {
            return p.key - this.key;
        }

        return p.value - this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pair)) {
            return false;
        }

        Pair p = (Pair) o;

        return this.key == p.key && this.value == p.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

class Solution {
    Map<Integer, Integer> map;
    TreeMap<Pair, Integer> topX;
    TreeMap<Pair, Integer> remain;
    long topSum;
    int X;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        this.X = x;
        topSum = 0;
        map = new HashMap<>();
        topX = new TreeMap<>();
        remain = new TreeMap<>();
        long ans[] = new long[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = topSum;

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = topSum;
        }

        return ans;
    }

    public void add(int num) {
        int old = map.getOrDefault(num, 0);
        map.put(num, old + 1);

        Pair oldPair = new Pair(num, old);
        if (old > 0) {
            if (topX.containsKey(oldPair)) {
                topX.remove(oldPair);
                topSum -= (long) num * old;
            } else {
                remain.remove(oldPair);
            }
        }

        Pair newPair = new Pair(num, old + 1);
        remain.put(newPair, 1);

        rebalance();
    }

    public void remove(int num) {
        int old = map.getOrDefault(num, 0);

        Pair oldPair = new Pair(num, old);
        if (topX.containsKey(oldPair)) {
            topX.remove(oldPair);
            topSum -= (long) num * old;
        } else {
            remain.remove(oldPair);
        }

        if (old == 1) {
            map.remove(num);
        } else {
            remain.put(new Pair(num, old - 1), 1);
            map.put(num, old - 1);
        }

        rebalance();
    }

    public void rebalance() {
        while (topX.size() < X && !remain.isEmpty()) {
            Pair p = remain.firstKey();
            remain.remove(p);
            topX.put(p, 1);
            topSum += (long) p.key * p.value;
        }

        while (topX.size() > X) {
            Pair p = topX.lastKey();
            topX.remove(p);
            remain.put(p, 1);
            topSum -= (long) p.key * p.value;
        }

        if (!topX.isEmpty() && !remain.isEmpty()) {
            while (!topX.isEmpty() && !remain.isEmpty() && topX.lastKey().compareTo(remain.firstKey()) > 0) {
                Pair small = topX.lastKey();
                Pair large = remain.firstKey();

                topX.remove(small);
                remain.remove(large);

                topX.put(large, 1);
                remain.put(small, 1);

                topSum -= (long) small.key * small.value;
                topSum += (long) large.key * large.value;
            }
        }
    }
}