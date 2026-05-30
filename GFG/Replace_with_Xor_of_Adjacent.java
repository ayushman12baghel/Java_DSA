import java.util.*;

class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int prev = arr[0];
        arr[0] = arr[0] ^ arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            int val = prev ^ arr[i + 1];
            prev = arr[i];
            arr[i] = val;
        }

        arr[arr.length - 1] = arr[arr.length - 1] ^ prev;
    }
}