import java.util.*;

//Approach O(n*9)
class Solution {
    public int minPartitions(String n) {
        int count = 0;
        char digits[] = n.toCharArray();

        while (true) {
            boolean changed = false;
            for (int i = 0; i < n.length(); i++) {
                if (digits[i] != '0') {
                    digits[i]--;
                    changed = true;
                }
            }

            if (!changed) {
                return count;
            }

            count++;
        }
    }
}

// Approach 2 O(n)
class Solution {
    public int minPartitions(String n) {
        char max = '0';

        for (char c : n.toCharArray()) {
            max = (char) Math.max(max, c);
        }

        return max - '0';
    }
}