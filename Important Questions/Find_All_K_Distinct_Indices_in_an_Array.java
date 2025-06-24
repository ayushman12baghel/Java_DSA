import java.util.ArrayList;
import java.util.List;

public class Find_All_K_Distinct_Indices_in_an_Array {

    // O(n^2)
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }

    // O(n)
    public static List<Integer> findKDistantIndices2(int[] nums, int key, int k) {
        List<Integer> store = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                store.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j : store) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }

    // O(n)
    public static List<Integer> findKDistantIndices3(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int right = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                int left = Math.max(right, j - k);
                right = Math.min(j + k, nums.length - 1) + 1;

                for (int i = left; i < right; i++) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 4, 9, 1, 3, 9, 5 };
        int key = 9, k = 1;

        System.out.println(findKDistantIndices(nums, key, k));
        System.out.println(findKDistantIndices2(nums, key, k));
        System.out.println(findKDistantIndices3(nums, key, k));
    }
}
