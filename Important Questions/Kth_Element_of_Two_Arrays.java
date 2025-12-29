import java.util.*;

// Approach Two Pointer O(n+m)
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int element = -1;

        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                element = b[j];
                j++;
            } else {
                element = a[i];
                i++;
            }

            count++;

            if (count == k) {
                return element;
            }
        }

        while (i < a.length) {
            element = a[i];
            count++;
            i++;
            if (count == k) {
                return element;
            }
        }

        while (j < b.length) {
            element = b[j];
            count++;
            j++;
            if (count == k) {
                return element;
            }
        }

        return -1;
    }
}