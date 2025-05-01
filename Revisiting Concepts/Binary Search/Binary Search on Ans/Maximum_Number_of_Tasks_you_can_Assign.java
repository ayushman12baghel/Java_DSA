import java.util.*;

public class Maximum_Number_of_Tasks_you_can_Assign {

    // Binary Search on Ans
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int taskCount = tasks.length;
        int workerCount = workers.length;

        int left = 1;
        int maxTasks = 0;
        int right = Math.min(taskCount, workerCount);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(tasks, workers, pills, strength, mid)) {
                maxTasks = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxTasks;
    }

    // Approach 1 Using TreeSet
    public static boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int requiredPills = pills;
        TreeMap<Integer, Integer> workerAvailable = new TreeMap<>();

        for (int i = workers.length - mid; i < workers.length; i++) {
            workerAvailable.put(workers[i], workerAvailable.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; i--) {
            Integer bestWorker = workerAvailable.lastKey();

            if (bestWorker >= tasks[i]) {
                workerAvailable.put(bestWorker, workerAvailable.get(bestWorker) - 1);
                if (workerAvailable.get(bestWorker) == 0) {
                    workerAvailable.remove(bestWorker);
                }
            } else {
                if (requiredPills == 0) {
                    return false;
                }

                bestWorker = workerAvailable.ceilingKey(tasks[i] - strength);

                if (bestWorker == null) {
                    return false;
                }

                workerAvailable.put(bestWorker, workerAvailable.get(bestWorker) - 1);
                if (workerAvailable.get(bestWorker) == 0) {
                    workerAvailable.remove(bestWorker);
                }

                requiredPills--;
            }
        }

        return true;
    }

    // Approach 2 Using Deque
    public static boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int remainingPills = pills;
        Deque<Integer> workerAvailable = new ArrayDeque<>();
        int workerCount = workers.length;

        int workerIndex = workerCount - 1;

        for (int i = mid - 1; i >= 0; i--) {
            while (workerIndex >= workerCount - mid && workers[workerIndex] + strength >= tasks[i]) {
                workerAvailable.addFirst(workers[workerIndex]);
                workerIndex--;
            }

            if (workerAvailable.isEmpty()) {
                return false;
            } else if (workerAvailable.getLast() >= tasks[i]) {
                workerAvailable.pollLast();
            } else {
                if (remainingPills == 0) {
                    return false;
                }

                remainingPills--;
                workerAvailable.pollFirst();
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int tasks[] = { 3, 2, 1 };
        int workers[] = { 0, 3, 3 };
        int pills = 1;
        int strength = 1;

        System.out.println(maxTaskAssign(tasks, workers, pills, strength));
    }
}
