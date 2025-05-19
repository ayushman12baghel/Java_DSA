public class Type_of_Triangle {

    public static String triangleType(int[] nums) {
        if (!isTriangle(nums)) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public static boolean isTriangle(int nums[]) {
        if ((nums[0] + nums[1] > nums[2]) && (nums[0] + nums[2] > nums[1]) && (nums[1] + nums[2] > nums[0])) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 4, 5 };
        System.out.println(triangleType(nums));
    }
}
