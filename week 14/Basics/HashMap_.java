import java.util.*;

public class HashMap_ {
    public static void main(String args[]) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // insert O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Africa", 50);

        System.out.println(hm);

        // get O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        // containsKey O(1)
        System.out.println(hm.containsKey("India"));

        // remove O(1)
        hm.remove("China");
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // isEmpty
        hm.clear();
        System.out.println(hm.isEmpty());

    }
}
