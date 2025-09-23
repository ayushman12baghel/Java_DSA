import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        String words1[] = version1.split("\\.");
        String words2[] = version2.split("\\.");
        int n = words1.length;
        int m = words2.length;
        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            int value1 = (i < n ? Integer.parseInt(words1[i]) : 0);
            int value2 = (j < m ? Integer.parseInt(words2[j]) : 0);

            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }

            i++;
            j++;
        }

        return 0;
    }
}