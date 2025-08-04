import java.util.*;

public class Fruits_Into_Baskets {

    // Approach Using SLiding Window O(n)
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int fruits[] = { 1, 2, 3, 2, 2 };

        System.out.println(totalFruit(fruits));
    }
}
