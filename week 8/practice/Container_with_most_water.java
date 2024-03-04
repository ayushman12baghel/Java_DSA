import java.util.*;

public class Container_with_most_water {
    public static int MostWater(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < height.size(); i++) {
            for (int j = 1; j < height.size(); j++) {
                int min_height = Math.min(height.get(i), height.get(j));
                int indexGap = j - i;
                int water_stored = min_height * (indexGap);
                if (water_stored > maxWater) {
                    maxWater = water_stored;
                }
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(7);
        height.add(7);
        System.out.println(MostWater(height));
    }
}
