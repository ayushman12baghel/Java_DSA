import java.util.*;

public class Permutations {

    public static List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList(), nums);

        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int nums[]) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList(temp));
            return;
        }

        for (int num : nums) {
            if (temp.contains(num)) {
                continue;
            }

            temp.add(num);
            backtrack(list, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };

        List<List<Integer>> list = permute(nums);

        for (List<Integer> x : list) {
            System.out.println(x);
        }
    }
}
