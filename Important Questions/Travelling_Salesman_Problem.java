import java.util.*;

public class Travelling_Salesman_Problem {

    // Approach 1 Brute Force O(n!)
    static int minCost1 = Integer.MAX_VALUE;

    public static int tsp(int[][] cost) {
        int n = cost.length;
        int cities[] = new int[n - 1];
        for (int i = 1; i < n; i++) {
            cities[i - 1] = i;
        }

        permute(cities, 0, cost);

        return minCost1;
    }

    public static void permute(int cities[], int index, int cost[][]) {
        if (index == cities.length) {
            calculateCost(cities, cost);
            return;
        }

        for (int i = index; i < cities.length; i++) {
            swap(cities, i, index);
            permute(cities, index + 1, cost);
            swap(cities, i, index);
        }
    }

    public static void calculateCost(int cities[], int cost[][]) {
        int total = 0;
        int currentCity = 0;

        for (int city : cities) {
            total += cost[currentCity][city];
            currentCity = city;
        }

        total += cost[currentCity][0];

        minCost1 = Math.min(minCost1, total);
    }

    public static void swap(int cities[], int i, int j) {
        int temp = cities[i];
        cities[i] = cities[j];
        cities[j] = temp;
    }

    // Approach 2 Doing BitMask + Memoisation O(n^2 * 2^n)
    public static int tsp2(int[][] cost) {
        int n = cost.length;
        int maxMask = (1 << n);
        int dp[][] = new int[maxMask][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(cost, 1, 0, dp);
    }

    public static int solve(int cost[][], int mask, int curr, int dp[][]) {
        if (mask == (1 << cost.length) - 1) {
            return cost[curr][0];
        }

        if (dp[mask][curr] != -1) {
            return dp[mask][curr];
        }

        int minCost = Integer.MAX_VALUE;

        for (int next = 0; next < cost.length; next++) {
            if ((mask & (1 << next)) == 0) {
                int newMask = (mask | 1 << next);
                int newCost = cost[curr][next] + solve(cost, newMask, next, dp);
                minCost = Math.min(minCost, newCost);
            }
        }

        return dp[mask][curr] = minCost;
    }

    public static void main(String[] args) {
        int cost[][] = { { 0, 1000, 5000 }, { 5000, 0, 1000 }, { 1000, 5000, 0 } };

        System.out.println(tsp(cost));
        System.out.println(tsp2(cost));
    }
}
