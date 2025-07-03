package Codeforces.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_2_Potions_Hard_Version {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputStrings = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]);
        }

        // HashMap<String, Integer> map = new HashMap<>();

        // int ans = solve(arr, 0, 0, map);

        // System.out.println(ans);

        System.out.println(solve(arr));
    }

    // public static int solve(int nums[], int i, int currentSum, HashMap<String,
    // Integer> map) {
    // if (i >= nums.length) {
    // return 0;
    // }

    // String key = i + "," + currentSum;
    // if (map.containsKey(key)) {
    // return map.get(key);
    // }

    // int notTake = solve(nums, i + 1, currentSum, map);

    // int take = 0;
    // if (currentSum + nums[i] >= 0) {
    // take = 1 + solve(nums, i + 1, currentSum + nums[i], map);
    // }

    // int result = Math.max(take, notTake);
    // map.put(key, result);

    // return result;
    // }

    public static int solve(int nums[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minHeap.offer(nums[i]);
            count++;

            if (sum < 0) {
                int mostNegative = minHeap.poll();
                sum -= mostNegative;
                count--;
            }
        }

        return count;
    }
}