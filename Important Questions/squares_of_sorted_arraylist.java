import java.util.*;

public class squares_of_sorted_arraylist {
    public static ArrayList<Integer> SquaredSortedArray(ArrayList<Integer> nums) {
        ArrayList<Integer> t = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, nums.get(i) * nums.get(i));
        }
        for (int i = 0; i < nums.size(); i++) {
            t.add(0);
        }
        int left = 0;
        int right = nums.size() - 1;
        int index = nums.size() - 1;
        while (left <= right) {
            if (nums.get(left) > nums.get(right)) {
                t.set(index, nums.get(left));
                left++;
            } else {
                t.set(index, nums.get(right));
                right--;
            }
            index--;
        }
        return t;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(-4);
        nums.add(-1);
        nums.add(0);
        nums.add(3);
        nums.add(10);
        System.out.println(SquaredSortedArray(nums));
    }
}
