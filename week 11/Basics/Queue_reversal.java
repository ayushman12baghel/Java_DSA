import java.util.*;

public class Queue_reversal {
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.peek());
            q.remove();
        }
        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        queueReversal(q);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
