import java.utl.*;

class Router {

    static class Packet {
        int source;
        int destination;
        int time;

        public Packet(int source, int destination, int time) {
            this.time = time;
            this.source = source;
            this.destination = destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof Packet)) {
                return false;
            }

            Packet object = (Packet) o;

            return this.time == object.time && this.source == object.source && this.destination == object.destination;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, time);
        }
    }

    int capacity;
    Deque<Packet> deque;
    Map<Integer, ArrayList<Integer>> map;
    Set<Packet> set;

    public Router(int memoryLimit) {
        capacity = memoryLimit;
        deque = new ArrayDeque<>();
        map = new HashMap<>();
        set = new HashSet<>();
    }

    public boolean addPacket(int source, int destination, int time) {
        Packet p = new Packet(source, destination, time);

        if (set.contains(p)) {
            return false;
        }

        if (deque.size() >= capacity) {
            Packet old = deque.pollFirst();
            remove(old);
        }

        deque.addLast(p);
        set.add(p);

        map.putIfAbsent(destination, new ArrayList<>());
        ArrayList<Integer> list = map.get(destination);

        int insertPos = lowerBound(list, time);
        list.add(insertPos, time);

        return true;
    }

    public int[] forwardPacket() {
        if (deque.isEmpty()) {
            return new int[] {};
        }

        Packet p = deque.pollFirst();
        remove(p);

        return new int[] { p.source, p.destination, p.time };
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!(map.containsKey(destination))) {
            return 0;
        }

        ArrayList<Integer> list = map.get(destination);
        int lower = lowerBound(list, startTime);
        int upper = upperBound(list, endTime);

        return upper - lower;
    }

    public void remove(Packet p) {
        set.remove(p);
        ArrayList<Integer> list = map.get(p.destination);

        int insertPos = lowerBound(list, p.time);

        if (insertPos < list.size() && p.time == list.get(insertPos)) {
            list.remove(insertPos);
        }

        if (list.isEmpty()) {
            map.remove(p.destination);
        }
    }

    public int lowerBound(ArrayList<Integer> list, int value) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int upperBound(ArrayList<Integer> list, int value) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */