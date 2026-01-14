import java.util.*;

//O(nlog(max(y)))
class Solution {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE;
        double right = Double.MIN_VALUE;
        double total = 0;

        for (int i = 0; i < squares.length; i++) {
            int y = squares[i][1];
            int length = squares[i][2];

            total += 1L * length * length;

            left = Math.min(left, y);
            right = Math.max(right, y + length);
        }

        double target = total / 2.0;

        while (left < right) {
            if (right - left < 1e-5) {
                break;
            }

            double mid = left + (right - left) / 2.0;

            if (areaBelow(squares, mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public double areaBelow(int squares[][], double mid) {
        double area = 0;

        for (int square[] : squares) {
            double y = square[1];
            double length = square[2];
            if (y > mid) {
                continue;
            }

            if (mid >= y + length) {
                area += length * length;
            } else {
                area += length * (mid - y);
            }
        }

        return area;
    }
}