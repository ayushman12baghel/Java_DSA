import java.util.*;

public class Maximum_Area_of_Longest_Diagonal_Possible {

    // Greedy
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int maxSquared = (dimensions[0][0] * dimensions[0][0]) + (dimensions[0][1] * dimensions[0][1]);
        int maxIndex = 0;
        int maxArea = dimensions[0][0] * dimensions[0][1];

        for (int i = 1; i < dimensions.length; i++) {
            int currentSquared = (dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]);
            int currentArea = dimensions[i][0] * dimensions[i][1];

            if (currentSquared > maxSquared || (currentSquared == maxSquared && maxArea < currentArea)) {
                maxSquared = currentSquared;
                maxIndex = i;
                maxArea = currentArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int dimensions[][] = { { 9, 3 }, { 8, 6 } };

        System.out.println(areaOfMaxDiagonal(dimensions));
    }
}
