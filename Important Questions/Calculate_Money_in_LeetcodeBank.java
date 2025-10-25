import java.util.*;

// Approach 1 Simulation O(n)
class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int monday = 1;

        while (n > 0) {
            int prev = monday;
            int days = Math.min(n, 7);
            for (int i = 0; i < days; i++) {
                total += prev;
                prev++;
                n--;
            }
            monday += 1;
        }

        return total;
    }
}

// Approach 2 Using AP and Sum of AP O(1)
class Solution {
    public int totalMoney(int n) {
        int term = n / 7; // Weeks
        int first = 28;
        int last = 28 + (term - 1) * 7;

        int totalSum = term * (first + last) / 2;

        int startMoney = term + 1;
        for (int day = 0; day < n % 7; day++) {
            totalSum += startMoney;
            startMoney++;
        }

        return totalSum;
    }
}