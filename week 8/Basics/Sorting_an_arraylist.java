import java.util.*;

public class Sorting_an_arraylist {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(20);
        list.add(-1);
        System.out.println(list);
        // Collections.sort(list);
        list.sort(null);
        Collections.reverse(list);

        System.out.println(list);
    }
}
