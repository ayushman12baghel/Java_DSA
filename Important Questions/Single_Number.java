import java.util.*;

public class Single_Number {

    public static int singleNumber(int nums[]) {
        // method 1 bit mainpulation xor gate

        int x = 0;

        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        return x;
    }

    public static int singleNumber2(int nums[]) {
        // method 2 bit using sort

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    public static void main(String[] args) {

        int nums[] = { 4, 1, 2, 1, 2 };

        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));

    }
}
