class Solution {
    public boolean canSplit(int arr[]) {
        int total = 0;

        for (int num : arr) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        int prefixSum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            prefixSum += arr[i];

            if (prefixSum == target) {
                return true;
            }
        }

        return false;
    }
}