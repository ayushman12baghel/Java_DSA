import java.util.*;

public class LinkedHashSet_ {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bhopal");
        cities.add("Indore");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Bhopal");
        lhs.add("Indore");

        System.out.println(lhs);
    }
}
