import java.util.*;

public class Find_The_Winner_of_Array_Game {

    // Approach Using Array Simulation
    // This Question is Asked by Microsoft today in OA round
    public static int getWinner(int nums[], int k) {
        int maxElement = nums[0];

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        if (k >= nums.length) {
            return maxElement;
        }

        int winner = nums[0];
        int winStreak = 0;

        for (int i = 1; i < nums.length; i++) {
            if (winner > nums[i]) {
                winStreak++;
            } else {
                winner = nums[i];
                winStreak = 1;
            }

            if (winStreak == k || winner == maxElement) {
                return winner;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 5, 4, 6, 7 };
        int k = 2;

        System.out.println(getWinner(nums, k));
    }
}
