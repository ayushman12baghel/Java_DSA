import java.util.*;

//O(n)
class Solution {
    public String largestSwap(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int maxRight[] = new int[n];
        maxRight[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[maxRight[i + 1]]) {
                maxRight[i] = i;
            } else {
                maxRight[i] = maxRight[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[maxRight[i]]) {
                char temp = arr[i];
                arr[i] = arr[maxRight[i]];
                arr[maxRight[i]] = temp;

                return new String(arr);
            }
        }

        return s;
    }
}