import java.util.*;

// Approach 1 O(n^2)
class Solution {
    public int josephus(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }
}

// Approach 2 O(n)
class Solution {
    public int josephus(int n, int k) {
        int ans = 0;

        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }

        return ans + 1;
    }
}