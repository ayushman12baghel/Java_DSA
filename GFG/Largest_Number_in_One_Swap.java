import java.util.*;

//Approach Greedy O(n)
class Solution {
    public String largestSwap(String s) {
        char arr[] = s.toCharArray();
        int lastIndex[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            lastIndex[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    char temp = arr[i];
                    arr[i] = arr[lastIndex[d]];
                    arr[lastIndex[d]] = temp;

                    return new String(arr);
                }
            }
        }

        return s;
    }
}