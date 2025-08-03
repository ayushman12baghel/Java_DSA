import java.util.*;

public class Rearranging_Fruits {

    public static long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long minValue = Integer.MAX_VALUE;

        // Populate the map and find the minimum element from basket1
        for (int num : basket1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            minValue = Math.min(minValue, num);
        }

        // Update the map with elements from basket2
        for (int num : basket2) {
            map.put(num, map.getOrDefault(num, 0) - 1);
            minValue = Math.min(minValue, num);
        }

        List<Integer> finalList = new ArrayList<>();

        // Process the map to create finalList
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cost = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            } else if (count % 2 != 0) {
                return -1; // Immediate return if counts are not even
            }

            // Add half of the count to finalList
            for (int i = 1; i <= Math.abs(count) / 2; i++) {
                finalList.add(cost);
            }
        }

        // Find the min of the elements
        Collections.sort(finalList); // Since we're dealing with costs, we can sort to find the minimum values
        long ans = 0;

        for (int i = 0; i < finalList.size() / 2; i++) {
            ans += Math.min(finalList.get(i), minValue * 2);// Calculate the minimum cost by using the least costs

        }

        return ans;
    }

    public static void main(String[] args) {
        int basket1[] = { 4, 2, 2, 2 }, basket2[] = { 1, 4, 1, 2 };

        System.out.println(minCost(basket1, basket2));
    }
}
