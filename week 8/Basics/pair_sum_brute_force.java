import java.util.ArrayList;

public class pair_sum_brute_force {
    public static void pairSum(ArrayList<Integer> list, int target) {
        ArrayList<ArrayList> arr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                if (list.get(i) + list.get(j) == target) {
                    temp.add(list.get(i));
                    temp.add(list.get(j));
                    arr.add(temp);
                }
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(i);
        }
        pairSum(list, 5);
    }
}
