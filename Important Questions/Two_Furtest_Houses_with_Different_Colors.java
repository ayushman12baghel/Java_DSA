import java.util.*;

//Approach O(n)
class Solution {
    public int maxDistance(int[] colors) {
        int maxDistance = 0;

        int i = 0;
        int j = colors.length - 1;

        while (i < j) {
            while (i < j && colors[i] == colors[j]) {
                i++;
            }

            if (colors[i] != colors[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                i++;
            } else {
                j--;
            }
        }

        i = 0;
        j = colors.length - 1;
        while (i < j) {
            while (i < j && colors[i] == colors[j]) {
                j--;
            }

            if (colors[i] != colors[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                j--;
            } else {
                i++;
            }
        }

        return maxDistance;
    }
}