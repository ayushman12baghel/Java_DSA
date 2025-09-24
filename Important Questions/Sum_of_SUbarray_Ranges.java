import java.util.Stack;

public class Sum_of_SUbarray_Ranges {

    public static int subarrayRanges(int nums[]) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                ans += max - min;
            }
        }

        return ans;
    }

    // Approach2 Using Stack and Code of Sum of Subarray Minimums
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int left[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        int right[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + ((long) (i - left[i]) * (right[i] - i) * nums[i]);
        }

        return ans;
    }

    public long sumSubarrayMaxs(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int left[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        int right[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + ((long) (i - left[i]) * (right[i] - i) * nums[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };

        System.out.println(subarrayRanges(nums));
    }
}
