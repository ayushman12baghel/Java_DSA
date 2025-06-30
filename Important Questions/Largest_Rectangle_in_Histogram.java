import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = nextSmallerElement(heights, n);
        int pse[] = previousSmallerElement(heights, n);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int[] nextSmallerElement(int heights[], int n) {
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] previousSmallerElement(int heights[], int n) {
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };

    }
}
