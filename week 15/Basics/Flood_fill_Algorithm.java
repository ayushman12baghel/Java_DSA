import java.util.*;

public class Flood_fill_Algorithm {
    public void helper(int[][] image, int sr, int sc, int color, boolean vis[], int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc]
                || image[sr][sc] != orgColor) {
            return;
        }

        // left
        helper(image, sr, sc - 1, color, vis, orgColor);

        // right
        helper(image, sr, sc + 1, color, vis, orgColor);

        // up
        helper(image, sr - 1, sc, color, vis, orgColor);

        // down
        helper(image, sr + 1, sc, color, vis, orgColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

}
