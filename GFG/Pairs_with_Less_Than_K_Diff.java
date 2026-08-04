//Approach O(nlogn)
import java.util.Arrays;

class Solution {
    int countPairs(int arr[], int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int i = 0, j = 1;
        int ans = 0;

        while (j < n) {
            if (arr[j] - arr[i] < k) {
                ans += (j - i);
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }

        return ans;
    }
}
