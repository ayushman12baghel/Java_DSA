public class Container_With_Most_Water {

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int ht = Math.min(height[left], height[right]);
            int width = right - left;
            int water = ht * width;
            max = Math.max(max, water);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
    }
}
