import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_With_Higher_Frequency {

    public static ArrayList<Integer> findGreater(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(nums[i])) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }

            stack.push(nums[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : ans) {
            result.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 1, 3, 2, 1 };

        System.out.println(findGreater(nums));
    }
}
