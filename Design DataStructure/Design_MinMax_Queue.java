import java.util.*;

//Maintaining MaxDeque and MinDeque
class SpecialQueue {
    Deque<Integer> deque;
    Deque<Integer> minDeque;
    Deque<Integer> maxDeque;

    public SpecialQueue() {
        // Define Data Structures
        deque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        deque.offer(x);

        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);

        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);
    }

    public void dequeue() {
        // Remove element from the queue
        if (!deque.isEmpty()) {
            int x = deque.poll();

            if (x == minDeque.peekFirst()) {
                minDeque.pollFirst();
            }

            if (x == maxDeque.peekFirst()) {
                maxDeque.pollFirst();
            }
        }
    }

    public int getFront() {
        // Get front element
        return deque.peekFirst();
    }

    public int getMin() {
        // Get minimum element
        return minDeque.peekFirst();
    }

    public int getMax() {
        // Get maximum element
        return maxDeque.peekFirst();
    }
}