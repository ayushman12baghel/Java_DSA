import java.util.*;

public class Maximum_Candies_You_can_get_From_Boxes {

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
            int[] initialBoxes) {

        int candiesCollected = 0;
        boolean visited[] = new boolean[status.length];
        Set<Integer> foundBoxes = new HashSet<>();

        for (int box : initialBoxes) {
            candiesCollected += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        return candiesCollected;
    }

    public static int dfs(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes, boolean visited[],
            Set<Integer> foundBoxes) {
        if (visited[box]) {
            return 0;
        }

        if (status[box] == 0) {
            foundBoxes.add(box);
            return 0;
        }

        visited[box] = true;
        int candiesCollected = candies[box];

        for (int insideBox : containedBoxes[box]) {
            candiesCollected += dfs(insideBox, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        for (int boxKey : keys[box]) {
            status[boxKey] = 1;

            if (foundBoxes.contains(boxKey)) {
                candiesCollected += dfs(boxKey, status, candies, keys, containedBoxes, visited, foundBoxes);
            }
        }

        return candiesCollected;
    }

    public static void main(String args[]) {
        int status[] = { 1, 0, 1, 0 };
        int candies[] = { 7, 5, 4, 100 };
        int keys[][] = { {}, {}, { 1 }, {} };
        int containedBoxes[][] = { { 1, 2 }, { 3 }, {}, {} };
        int initialBoxes[] = { 0 };
    }
}
