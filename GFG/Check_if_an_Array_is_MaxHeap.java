import java.util.*;

//Approach O(n)
class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            int par = (i - 1) / 2;

            if (i > 0 && arr[par] < arr[i]) {
                return false;
            }
        }

        return true;
    }
}