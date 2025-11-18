import java.util.*;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i;
        for (i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                i++;
            }
        }

        if (i == bits.length || bits[bits.length - 1] == 1) {
            return false;
        }

        return true;
    }
}