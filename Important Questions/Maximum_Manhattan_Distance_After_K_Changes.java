import java.util.*;

public class Maximum_Manhattan_Distance_After_K_Changes {

    public static int maxDistance(String str, int k) {
        int x = 0;
        int y = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }

            int currentDistance = Math.abs(x) + Math.abs(y);

            int afterChange = Math.min(currentDistance + 2 * k, i + 1);

            max = Math.max(max, afterChange);
        }

        return max;
    }

    public static void main(String args[]) {
        String str = "NWSE";
        int k = 1;

        System.out.println(maxDistance(str, k));
    }
}
