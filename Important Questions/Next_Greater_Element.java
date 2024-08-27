import java.util.*;

public class Next_Greater_Element {

    public static int[] nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int next[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = arr[s.peek()];
            }
            s.add(i);
        }

        return next;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };

        int next[] = nextGreater(arr);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
    }
}
