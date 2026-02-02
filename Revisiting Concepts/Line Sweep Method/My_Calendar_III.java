import java.util.*;

// Approach Using LineSweep Method O(n) per book call
class MyCalendarThree {
    TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
        events = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int currBookings = 0;
        int maxBookings = 0;

        for (int value : events.values()) {
            currBookings += value;
            maxBookings = Math.max(maxBookings, currBookings);
        }

        return maxBookings;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */