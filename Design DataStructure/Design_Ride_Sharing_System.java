import java.util.*;

//Approach Using Queue and Lazy Deletion using Set O(1) Time and O(n) space
class RideSharingSystem {
    Queue<Integer> riderQueue;
    Queue<Integer> driverQueue;
    Set<Integer> validRider;

    public RideSharingSystem() {
        riderQueue = new ArrayDeque<>();
        driverQueue = new ArrayDeque<>();
        validRider = new HashSet<>();
    }

    public void addRider(int riderId) {
        riderQueue.offer(riderId);
        validRider.add(riderId);
    }

    public void addDriver(int driverId) {
        driverQueue.offer(driverId);
    }

    public int[] matchDriverWithRider() {
        if (riderQueue.isEmpty() || driverQueue.isEmpty()) {
            return new int[] { -1, -1 };
        }

        while (!riderQueue.isEmpty()) {
            int current = riderQueue.poll();
            if (validRider.contains(current)) {
                validRider.remove(current);

                return new int[] { driverQueue.poll(), current };
            }
        }

        return new int[] { -1, -1 };
    }

    public void cancelRider(int riderId) {
        if (validRider.contains(riderId)) {
            validRider.remove(riderId);
        }
    }
}