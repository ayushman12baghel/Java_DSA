import java.util.*;

public class Alternating_Groups_I {

    public static int numberOfAlternatingGroups(int colors[]) {
        int prevColor = colors[colors.length - 1];
        int count = 0;

        for (int i = 0; i < colors.length; i++) {
            int nextColor = (i == colors.length - 1 ? colors[0] : colors[i + 1]);

            if (colors[i] != prevColor && colors[i] != nextColor) {
                count++;
            }

            prevColor = colors[i];
        }

        return count;
    }

    public static void main(String args[]) {
        int colors[] = { 0, 1, 0, 0, 1 };

        System.out.println(numberOfAlternatingGroups(colors));
    }
}
