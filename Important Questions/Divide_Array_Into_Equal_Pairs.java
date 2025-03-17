import java.util.*;

public class Divide_Array_Into_Equal_Pairs {

    // Approach 1 Using HashMap
    public static boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int value : map.values()) {
            if (value % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    // Approach 2 Using Set
    public static boolean divideArray2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.size() == 0;
    }

    // Approach 3 Using Sorting
    public static boolean divideArray3(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    // Approach 4 Using Sorting and Xor
    public static boolean divideArray4(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
            if ((nums[i] ^ nums[i - 1]) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
        System.out.println(divideArray2(nums));
        System.out.println(divideArray3(nums));
        System.out.println(divideArray4(nums));
    }
}
