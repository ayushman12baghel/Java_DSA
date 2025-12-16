import java.util.*;

// Approach Brute Force O(n*n!)
class Solution {
    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = permute(n);

        List<Integer> temp = ans.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : temp) {
            sb.append(num);
        }

        return sb.toString();
    }

    public List<List<Integer>> permute(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, new boolean[n + 1], new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int n, boolean visited[], List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            temp.add(i);
            visited[i] = true;
            solve(n, visited, temp, ans);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}

// Approach 2 Using Maths O(n^2)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }

        fact /= list.size();
        k--;

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(list.get(k / fact));
            list.remove(k / fact);
            if (list.size() == 0) {
                return sb.toString();
            }

            k = k % fact;
            fact /= list.size();
        }
    }
}