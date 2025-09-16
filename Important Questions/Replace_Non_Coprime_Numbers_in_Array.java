import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty()) {
                int prev = stack.peek();

                int gcd = gcd(num, prev);

                if (gcd == 1) {
                    break;
                }

                stack.pop();
                long lcm = (prev / gcd) * (long) num;
                num = (int) lcm;
            }

            stack.push(num);
        }

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        Collections.reverse(ans);

        return ans;
    }

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}

// Using List as Stack
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            while (!ans.isEmpty()) {
                int prev = ans.get(ans.size() - 1);

                int gcd = gcd(num, prev);

                if (gcd == 1) {
                    break;
                }

                ans.remove(ans.size() - 1);
                long lcm = (prev / gcd) * (long) num;
                num = (int) lcm;
            }

            ans.add(num);
        }

        return ans;
    }

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}
