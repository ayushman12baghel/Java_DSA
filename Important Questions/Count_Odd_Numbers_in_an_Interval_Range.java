import java.util.*;

//Approach 1 Brute Force O(n)
class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 0) {
            low++;
        }

        for (int i = low; i <= high; i += 2) {
            count++;
        }

        return count;
    }
}

// Approach 2 Using Maths
class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 0) {
            low++;
        }

        if (high % 2 == 0) {
            high--;
        }

        return (high - low) / 2 + 1;
    }
}

// Approach 3
class Solution {
    public int countOdds(int low, int high) {

        return (high + 1) / 2 - low / 2;
    }
}