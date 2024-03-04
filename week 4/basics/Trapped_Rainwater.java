import java.util.*;

public class Trapped_Rainwater {
    public static int trapped_Rainwater(int height[]) {

        // calculation of left maximum boundary
        int left_Max[] = new int[height.length];
        left_Max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_Max[i] = Math.max(left_Max[i - 1], height[i]);
        }

        // calculation of right maximum boundary
        int right_Max[] = new int[height.length];
        right_Max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_Max[i] = Math.max(right_Max[i + 1], height[i]);
        }

        // loop
        int trappedwater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterlevel = Math.min(right_Max[i], left_Max[i]);

            trappedwater += waterlevel - height[i];
        }
        return trappedwater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trapped_Rainwater(height));
    }
}
