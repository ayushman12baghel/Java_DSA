import java.util.*;

public class FInd_Median_From_Datastream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println("Median after adding 1: " + medianFinder.findMedian()); // Output: 1.0

        medianFinder.addNum(2);
        System.out.println("Median after adding 2: " + medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNum(3);
        System.out.println("Median after adding 3: " + medianFinder.findMedian()); // Output: 2.0

        medianFinder.addNum(4);
        System.out.println("Median after adding 4: " + medianFinder.findMedian()); // Output: 2.5

        medianFinder.addNum(5);
        System.out.println("Median after adding 5: " + medianFinder.findMedian()); // Output: 3.0
    }
}

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
