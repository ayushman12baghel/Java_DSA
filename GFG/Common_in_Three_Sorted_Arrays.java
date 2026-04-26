import java.util.*;

// Approach O(n+m+o)
class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                ans.add(a[i]);
                i++;
                j++;
                k++;

                while (i < a.length && i > 0 && a[i] == a[i - 1]) {
                    i++;
                }
                while (j < b.length && j > 0 && b[j] == b[j - 1]) {
                    j++;
                }
                while (k < c.length && k > 0 && c[k] == c[k - 1]) {
                    k++;
                }
            } else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }
}