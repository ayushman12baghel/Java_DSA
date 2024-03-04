import java.util.ArrayList;

public class Arraylist_syntax {
    public static void main(String[] args) {
        // Java Collection Framework
        // String | Boolean | Float
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();
        ArrayList<Float> list4 = new ArrayList<>();
        list.add(1);// O(1);
        for (int i = 2; i < 9; i++) {
            list.add(i);
        }
        System.out.println(list);
        int element = list.get(2);
        // System.out.println(element);
        // list.remove(element);
        // System.out.println(list);
        list.set(2, 5);
        System.out.println(list);
        System.out.println(list.contains(4));
        list.add(1, 9);
        // list.remove(element);
        // System.out.println(list);
        System.out.println(list.size());
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
