import java.util.*;

// Approach Using Backtracking and getting all Combinations O(1) maximum Combinations = 252
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        if (turnedOn >= 9) {
            return ans;
        }

        int hours[] = { 8, 4, 2, 1 };
        int minutes[] = { 32, 16, 8, 4, 2, 1 };

        solve(turnedOn, hours, minutes, 0, 0, 0, 0, ans);
        Collections.sort(ans);

        return ans;
    }

    public void solve(int n, int hours[], int minutes[], int hourIndex, int minuteIndex, int hourSum, int minuteSum,
            List<String> ans) {
        if (hourSum > 11 || minuteSum > 59) {
            return;
        }

        if (n == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hourSum);
            sb.append(':');

            if (minuteSum < 10) {
                sb.append('0');
            }
            sb.append(minuteSum);

            ans.add(sb.toString());
            return;
        }

        for (int i = hourIndex; i < hours.length; i++) {
            solve(n - 1, hours, minutes, i + 1, minuteIndex, hourSum + hours[i], minuteSum, ans);
        }

        for (int i = minuteIndex; i < minutes.length; i++) {
            solve(n - 1, hours, minutes, hours.length, i + 1, hourSum, minuteSum + minutes[i], ans);
        }
    }
}