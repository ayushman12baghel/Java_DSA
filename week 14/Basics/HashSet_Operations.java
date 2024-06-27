import java.util.*;

public class HashSet_Operations {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(3);
        set.add(5);

        System.out.println(set);

        set.remove(2);
        if (set.contains(2)) {
            System.out.println("contains key");
        } else {
            System.out.println("no contains");
        }

        set.clear();
        System.out.println(set.size());

        System.out.println(set.isEmpty());
    }
}
