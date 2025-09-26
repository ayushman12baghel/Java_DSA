import java.util.*;

class Solution {
    public static void rotateDeque(Deque<Integer> deque, int type, int k) {
        if (type == 1) {
            while (!deque.isEmpty() && k-- > 0) {
                int temp = deque.pollLast();
                deque.offerFirst(temp);
            }
        } else if (type == 2) {
            while (!deque.isEmpty() && k-- > 0) {
                int temp = deque.pollFirst();
                deque.offerLast(temp);
            }
        }
    }
}