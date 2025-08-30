import java.util.*;

//Approach 1 Using Brute Force O(n^2)
class Solution {
    public int celebrity(int matrix[][]) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean celebrity = true;

            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 1) {
                    celebrity = false;
                    break;
                }
            }

            if (celebrity) {
                for (int j = 0; j < n; j++) {
                    if (i != j && matrix[j][i] == 0) {
                        celebrity = false;
                        break;
                    }
                }
            }

            if (celebrity) {
                return i;
            }
        }

        return -1;
    }
}

// Approach 2 O(n) Two Pointer
class Solution {
    public int celebrity(int matrix[][]) {
        int n = matrix.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (matrix[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }

        boolean celebrity = true;

        for (int k = 0; k < n; k++) {
            if (k != i && (matrix[k][i] == 0 || matrix[i][k] == 1)) {
                celebrity = false;
            }
        }

        if (celebrity) {
            return i;
        }

        return -1;
    }
}

// Approach 3 Using Stack O(n)
class Solution {
    public int celebrity(int matrix[][]) {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (matrix[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (candidate != i && (matrix[i][candidate] == 0 || matrix[candidate][i] == 1)) {
                return -1;
            }
        }

        return candidate;
    }
}