import java.util.ArrayList;

public class pair_sum_2 {
    public static void pairSum(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while (lp != rp) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (list.get(lp) + list.get(rp) == target) {
                temp.add(list.get(lp));
                temp.add(list.get(rp));
                arr.add(temp);
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        System.out.println(arr);
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        pairSum(list, 16);
    }
}
