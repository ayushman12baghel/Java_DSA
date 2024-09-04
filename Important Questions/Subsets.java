import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, nums, new ArrayList(), list);

        return list;
    }

    public static void backtrack(int index, int nums[], List<Integer> subset, List<List<Integer>> list) {
        list.add(new ArrayList(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(i + 1, nums, subset, list);
            subset.remove(subset.size() - 1);
        }

    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> list = subsets(nums);

        for (List<Integer> x : list) {
            System.out.println(x);
        }
    }
}
