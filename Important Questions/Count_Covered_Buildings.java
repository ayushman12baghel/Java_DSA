import java.util.*;

// Approach 1 Using TreeMap and HashMap O(nlogn)
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, TreeSet<Integer>> mapX = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> mapY = new HashMap<>();

        for (int point[] : buildings) {
            int x = point[0];
            int y = point[1];

            mapX.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            mapY.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int count = 0;

        for (int point[] : buildings) {
            int x = point[0];
            int y = point[1];

            TreeSet<Integer> setX = mapX.get(x);
            TreeSet<Integer> setY = mapY.get(y);

            int firstX = setX.first();
            int lastX = setX.last();
            int firstY = setY.first();
            int lastY = setY.last();

            if (x > firstY && x < lastY && y > firstX && y < lastX) {
                count++;
            }
        }

        return count;
    }
}

// Approach 2 Using HashMap O(n)
class Pair {
    int min;
    int max;

    public Pair(int x, int y) {
        this.min = x;
        this.max = y;
    }
}

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, Pair> mapX = new HashMap<>();
        HashMap<Integer, Pair> mapY = new HashMap<>();

        for (int point[] : buildings) {
            int x = point[0];
            int y = point[1];

            mapX.putIfAbsent(x, new Pair(y, y));
            mapY.putIfAbsent(y, new Pair(x, x));
            Pair p1 = mapX.get(x);
            Pair p2 = mapY.get(y);
            p1.max = Math.max(p1.max, y);
            p1.min = Math.min(p1.min, y);
            p2.max = Math.max(p2.max, x);
            p2.min = Math.min(p2.min, x);
        }

        int count = 0;

        for (int point[] : buildings) {
            int x = point[0];
            int y = point[1];

            Pair pX = mapX.get(x);
            Pair pY = mapY.get(y);

            int firstX = pX.min;
            int lastX = pX.max;
            int firstY = pY.min;
            int lastY = pY.max;

            if (x > firstY && x < lastY && y > firstX && y < lastX) {
                count++;
            }
        }

        return count;
    }
}