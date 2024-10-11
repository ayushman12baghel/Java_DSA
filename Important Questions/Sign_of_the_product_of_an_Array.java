public class Sign_of_the_product_of_an_Array {

    public static int arraySign(int nums[]) {
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] > 0) {
                nums[i] = 1;
            } else if (nums[i] < 0) {
                nums[i] = -1;
            }
            sum *= nums[i];
        }

        return sum;
    }

    public static void main(String args[]) {
        int nums[] = { -1, -2, -3, -4, 3, 2, 1 };

        System.out.println(arraySign(nums));
    }
}
