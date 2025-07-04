import java.util.*;

public class Single_Number_III {

    public static int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int diffBit = xor & -xor;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 3, 2, 5 };
        int ans[] = singleNumber(nums);

        System.out.println(ans[0] + " " + ans[1]);
    }
}
