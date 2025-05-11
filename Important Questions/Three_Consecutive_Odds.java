public class Three_Consecutive_Odds {

    // Approach 1 Using Brute Force
    public static boolean threeConsecutiveOdds(int nums[]) {
        for (int i = 0; i <= nums.length - 3; i++) {
            boolean isPossible = true;

            for (int j = i; j < i + 3; j++) {
                if (nums[j] % 2 == 0) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                return true;
            }
        }

        return false;
    }

    // Approach 2
    public static boolean threeConsecutiveOdds2(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0) {
                return true;
            }
        }

        return false;
    }

    // Approach 3: Using Counting
    public static boolean threeConsecutiveOdds3(int[] nums) {
        int consecutiveOdds = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                consecutiveOdds++;
            } else {
                consecutiveOdds = 0;
            }

            if (consecutiveOdds == 3) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };

        System.out.println(threeConsecutiveOdds(nums));
        System.out.println(threeConsecutiveOdds2(nums));
        System.out.println(threeConsecutiveOdds3(nums));
    }
}
