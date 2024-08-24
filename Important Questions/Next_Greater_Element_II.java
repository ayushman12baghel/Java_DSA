import java.util.*;

public class Next_Greater_Element_II {

    public static int[] nextGreaterElement(int nums[]) {
        int n = nums.length;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i % n]) {
                res[s.pop()] = nums[i % n];
            }
            if (i < n) {
                s.push(i);
            }
        }

        return res;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 3 };

        int res[] = nextGreaterElement(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
