import java.util.*;

//Approach 1 Using Dynamic Programming O(n^2*m)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = (matrix[i][j] == '1' ? 1 + (j > 0 ? dp[i][j - 1] : 0) : 0);
                int width = dp[i][j];

                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    ans = Math.max(ans, width * (i - k + 1));
                }
            }
        }

        return ans;
    }
}

// Approach 2 Using Heights and Largest Rectangle in Histogram Logic O(n*m)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int heights[] = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[j] = (matrix[i][j] == '1' ? heights[j] + 1 : 0);
            }

            ans = Math.max(ans, getMaxArea(heights));
        }

        return ans;
    }

    public int getMaxArea(int heights[]) {
        int pse[] = previousSmallerElement(heights);
        int nse[] = nextSmallerElement(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = (nse[i] - pse[i] - 1);
            int area = (width * heights[i]);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] previousSmallerElement(int heights[]) {
        int n = heights.length;

        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    public int[] nextSmallerElement(int heights[]) {
        int n = heights.length;

        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}

// Combining nse and pse in single loop
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int heights[] = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[j] = (matrix[i][j] == '1' ? heights[j] + 1 : 0);
            }

            ans = Math.max(ans, getMaxArea(heights));
        }

        return ans;
    }

    public int getMaxArea(int heights[]) {
        int n = heights.length;

        int pse[] = new int[n];
        int nse[] = new int[n];
        Stack<Integer> stackP = new Stack<>();
        Stack<Integer> stackN = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stackP.isEmpty() && heights[stackP.peek()] >= heights[i]) {
                stackP.pop();
            }

            while (!stackN.isEmpty() && heights[stackN.peek()] >= heights[n - i - 1]) {
                stackN.pop();
            }

            pse[i] = (stackP.isEmpty() ? -1 : stackP.peek());
            nse[n - i - 1] = (stackN.isEmpty() ? n : stackN.peek());

            stackP.push(i);
            stackN.push(n - i - 1);
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = (nse[i] - pse[i] - 1);
            int area = (width * heights[i]);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}