class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            int mid = i / 2;
            long median = arr[mid];

            long leftSum = pref[mid];
            long rightSum = pref[i + 1] - pref[mid + 1];

            long leftCost = median * mid - leftSum;
            long rightCost = rightSum - median * (i - mid);

            ans.add((int)(leftCost + rightCost));
        }

        return ans;
    }
}
