import java.util.*;

public class Sort_Characters_by_Frequency {

    // Approach Using HashMap and then Sorting
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entrySet = new ArrayList<>(map.entrySet());
        Collections.sort(entrySet, (a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            char c = entry.getKey();
            int value = entry.getValue();

            for (int i = 0; i < value; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Aabb";
        System.out.println(frequencySort(str));
    }
}
