import java.util.*;

// Approach 1 O(root(n))
class Solution {
    int maxPeopleDefeated(int p) {
        int k = 0;
        int currentPerson = 1;

        while (p >= currentPerson * currentPerson) {
            p -= currentPerson * currentPerson;
            currentPerson++;
            k++;
        }

        return k;
    }
};

// Approach 2 O(log(root(n)))
class Solution {
    int maxPeopleDefeated(int p) {
        long low = 1;
        long high = 1000;
        long result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long strength = (mid * (mid + 1) * (2 * mid + 1)) / 6;

            if (strength <= p) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) result;
    }
};