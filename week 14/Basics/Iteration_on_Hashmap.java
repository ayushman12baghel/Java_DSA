import java.util.*;

public class Iteration_on_Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Africa", 50);

        // Iterate
        // entrySet();
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key: " + k + " , value: " + hm.get(k));
        }
    }
}
