import java.util.*;

// Approach Using Line Sweep O(n) per book call
class MyCalendar {
    TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int currSum = 0;

        for (int value : events.values()) {
            currSum += value;

            if (currSum > 1) {
                events.put(startTime, events.get(startTime) - 1);
                if (events.get(startTime) == 0) {
                    events.remove(startTime);
                }

                events.put(endTime, events.get(endTime) + 1);
                if (events.get(endTime) == 0) {
                    events.remove(endTime);
                }

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */