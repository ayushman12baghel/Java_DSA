import java.util.*;

public class Maximum_Width_Ramp {

    public static int maxWidthRamp(int nums[]) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxLen = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                maxLen = Math.max(maxLen, i - stack.pop());
            }
        }

        return maxLen;
    }

    public static void main(String args[]) {
        int nums[] = { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 };

        System.out.println(maxWidthRamp(nums));
    }
}
