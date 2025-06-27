import java.util.*;

public class A_Packing_Rectangles {

    public static long search(int h, int w, int n) {
        long left = 0;
        long right = (long) Math.max(h, w) * n;
        // long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long rectanglesInWidth = mid / w;
            long rectanglesInHeight = mid / h;

            long count;
            if (rectanglesInWidth > 0 && rectanglesInHeight > Long.MAX_VALUE / rectanglesInWidth) {
                count = Long.MAX_VALUE;
            } else {
                count = rectanglesInWidth * rectanglesInHeight;
            }

            if (count >= n) {
                // ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(search(h, w, n));
    }
}