import java.util.*;

public class Count_the_Number_of_Possible_Triangles {

    // Using Two Pointers
    public static int countTriangles(int nums[]) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;

        for (int last = n - 1; last >= 0; last--) {
            int left = 0;
            int right = last - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[last]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 6, 3, 7 };

        System.out.println(countTriangles(nums));
    }
}
