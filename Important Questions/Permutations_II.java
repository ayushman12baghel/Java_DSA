import java.util.*;

public class Permutations_II {
    // basic
    public static List<List<Integer>> permuteUnique(int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);

        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> curr, int nums[], boolean used[]) {
        if (curr.size() == nums.length && !list.contains(curr)) {
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            backtrack(list, curr, nums, used);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }

    // optimised

    public static List<List<Integer>> permuteUnique2(int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, new boolean[nums.length]);

        return list;
    }

    public static void backtrack2(List<List<Integer>> list, List<Integer> curr, int nums[], boolean used[]) {
        if (nums.length == curr.size()) {
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            backtrack2(list, curr, nums, used);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 2 };

        List<List<Integer>> list = permuteUnique(nums);

        for (List<Integer> x : list) {
            System.out.print(x + " ");
        }

        System.out.println();

        List<List<Integer>> list2 = permuteUnique2(nums);
        for (List<Integer> x : list2) {
            System.out.print(x + " ");
        }
    }
}
