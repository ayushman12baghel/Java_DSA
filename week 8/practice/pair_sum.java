import java.util.ArrayList;

public class pair_sum {
    public static void pairSum(ArrayList<Integer> list, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(list.get(lp));
                temp.add(list.get(rp));
                arr.add(temp);
                lp++;
                rp--;
            } else if (sum < target) {
                lp++;
            } else {
                rp--;
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
