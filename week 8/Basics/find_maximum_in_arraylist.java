import java.util.*;

public class find_maximum_in_arraylist {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println(list);
        System.out.println(max);
        list.sort(null);
        System.out.println(list);
        System.out.println(list.get(list.size() - 1));
    }
}
