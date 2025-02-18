import java.util.*;

public class Subsets_II {

    // Using Set
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        solve(nums, list, new ArrayList<>(), 0, set);

        return list;
    }

    public static void solve(int nums[], List<List<Integer>> list, List<Integer> temp, int index, Set<String> set) {
        String key = temp.toString();
        if (!set.contains(key)) {
            list.add(new ArrayList<>(temp));
            set.add(key);
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            solve(nums, list, temp, i + 1, set);
            temp.remove(temp.size() - 1);
        }
    }

    // Without using set
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, list, new ArrayList<>(), 0);

        return list;
    }

    public static void solve(int nums[], List<List<Integer>> list, List<Integer> temp, int index) {
        list.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            solve(nums, list, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 2 };

        System.out.println(subsetsWithDup(nums));
        System.out.println(subsetsWithDup2(nums));
    }
}
