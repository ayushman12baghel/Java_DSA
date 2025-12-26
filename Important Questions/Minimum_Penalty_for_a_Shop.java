import java.util.*;

//O(n)
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int maxCount = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                maxCount++;
            }
        }

        // if(maxCount==0){
        // return 0;
        // }

        int minAns = maxCount;
        int currentN = 0;
        int currentY = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);
            if (c == 'Y') {
                currentY++;
            } else if (c == 'N') {
                currentN++;
            }

            int currentPenalty = maxCount - currentY + currentN;
            if (currentPenalty < minAns) {
                minAns = currentPenalty;
                minIndex = i + 1;
            }
        }

        return minIndex;
    }
}