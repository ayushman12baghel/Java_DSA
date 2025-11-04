import java.util.*;

public class Find_X_Sum_of_All_K_Long_Subarrays_I {

    public static int[] findXSum(int nums[], int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            int subarray[] = Arrays.copyOfRange(nums, i, i + k);
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : subarray) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<HashMap.Entry<Integer, Integer>> freqList = new ArrayList<>(map.entrySet());

            freqList.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                } else {
                    return b.getKey() - a.getKey();
                }
            });

            int xSum = 0;
            int count = 0;

            for (HashMap.Entry<Integer, Integer> entry : freqList) {
                if (count < x) {
                    xSum += entry.getKey() * entry.getValue();
                    count++;
                } else {
                    break;
                }
            }

            result.add(xSum);
        }

        int ans[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 8, 7, 8, 7, 5 };
        int k = 2;
        int x = 2;

        int ans[] = findXSum(nums, k, x);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

// Approach 2 Using HashMap and PriorityQueue O(n*klogk)
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
}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = getXSum(map, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans[i - k + 1] = getXSum(map, x);
        }

        return ans;
    }

    public int getXSum(Map<Integer, Integer> map, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int sum = 0;

        while (!pq.isEmpty() && x-- > 0) {
            Pair top = pq.poll();
            sum += (top.key * top.value);
        }

        return sum;
    }
}

// Approach 3 Using TreeMap O(nlogk)
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

        return key == p.key && value == p.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        int ans[] = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Pair, Integer> tree = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            int old = map.getOrDefault(nums[i], 0);
            if (old > 0) {
                tree.remove(new Pair(nums[i], old));
            }

            map.put(nums[i], old + 1);
            tree.put(new Pair(nums[i], old + 1), 1);
        }

        ans[0] = getXSum(tree, x);

        for (int i = k; i < n; i++) {
            int old = map.get(nums[i - k]);
            tree.remove(new Pair(nums[i - k], old));
            if (old == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], old - 1);
                tree.put(new Pair(nums[i - k], old - 1), 1);
            }

            old = map.getOrDefault(nums[i], 0);
            if (old > 0) {
                tree.remove(new Pair(nums[i], old));
            }

            map.put(nums[i], old + 1);
            tree.put(new Pair(nums[i], old + 1), 1);

            ans[i - k + 1] = getXSum(tree, x);
        }

        return ans;
    }

    public int getXSum(TreeMap<Pair, Integer> tree, int x) {
        int sum = 0;
        int count = 0;

        for (Pair p : tree.keySet()) {
            if (count == x) {
                break;
            }

            sum += p.key * p.value;
            count++;
        }

        return sum;
    }
}