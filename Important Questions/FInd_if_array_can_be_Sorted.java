import java.util.*;

public class FInd_if_array_can_be_Sorted {

    public static boolean canSortArray(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] <= nums[j + 1]) {
                    continue;
                } else {
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }

        return true;
    }

    // Failing 5 test cases
    public static boolean canSortArray2(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int count = Integer.bitCount(num);
            map.put(count, map.getOrDefault(count, new ArrayList<>()));
            map.get(count).add(num);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int sorted[] = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            int count = Integer.bitCount(num);
            List<Integer> list = map.get(count);
            sorted[index++] = list.remove(0);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (sorted[i] > sorted[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int nums[] = { 8, 4, 2, 30, 15 };

        System.out.println(canSortArray(nums));
        System.out.println(canSortArray2(nums));
    }
}