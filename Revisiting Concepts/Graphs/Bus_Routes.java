import java.util.*;

//Approach Using BFS O(N^2*M)  where N=number of Buses and M= Stops
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> busToStops = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {

            for (int stop : routes[i]) {
                busToStops.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        if (busToStops.containsKey(source)) {
            for (int bus : busToStops.get(source)) {
                queue.offer(bus);
                visited.add(bus);
            }
        }

        int busCount = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int stop : routes[current]) {
                    if (stop == target) {
                        return busCount;
                    }

                    for (int nextRoute : busToStops.get(stop)) {
                        if (!visited.contains(nextRoute)) {
                            visited.add(nextRoute);
                            queue.offer(nextRoute);
                        }
                    }
                }
            }

            busCount++;
        }

        return -1;
    }
}

// More Optimised O(n*m)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> busToStops = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {

            for (int stop : routes[i]) {
                busToStops.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        if (busToStops.containsKey(source)) {
            for (int bus : busToStops.get(source)) {
                queue.offer(bus);
                visited.add(bus);
            }
        }

        int busCount = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int stop : routes[current]) {
                    if (stop == target) {
                        return busCount;
                    }

                    List<Integer> nextBuses = busToStops.get(stop);
                    if (nextBuses != null) {
                        for (int nextRoute : nextBuses) {
                            if (!visited.contains(nextRoute)) {
                                visited.add(nextRoute);
                                queue.offer(nextRoute);
                            }
                        }

                        busToStops.remove(stop);
                    }
                }
            }

            busCount++;
        }

        return -1;
    }
}