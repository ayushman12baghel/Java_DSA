import java.util.*;

public class Validate_Stack_Sequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()) {
                if (stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        int pushed[] = { 1, 2, 3, 4, 5 };
        int popped[] = { 4, 5, 3, 2, 1 };

        System.out.println(validateStackSequences(pushed, popped));
    }
}
