import java.util.*;

// Greedy O(n)
class Solution {
    public String chooseSwap(String s) {
        int firstIndex[] = new int[26];
        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] == -1) {
                firstIndex[s.charAt(i) - 'a'] = i;
            }
        }

        boolean swapped = false;
        char first = ' ';
        char second = ' ';

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            for (int j = 0; j < current - 'a'; j++) {
                if (firstIndex[j] > i) {
                    first = current;
                    second = (char) (j + 'a');
                    swapped = true;
                    break;
                }
            }

            if (swapped) {
                break;
            }
        }

        if (!swapped) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                sb.append(second);
            } else if (s.charAt(i) == second) {
                sb.append(first);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}