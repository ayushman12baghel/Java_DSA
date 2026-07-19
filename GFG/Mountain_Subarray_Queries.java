class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                inc[i] = inc[i + 1];
            else
                inc[i] = i;
        }

        dec[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i])
                dec[i] = dec[i - 1];
            else
                dec[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(inc[q[0]] >= dec[q[1]]);
        }

        return ans;
    }
}
