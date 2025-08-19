import java.util.*;

public class Swap_Time {

    public static int swapTime(String color) {
        int zeros = 0;
        int time = 0;

        for (char c : color.toCharArray()) {
            if (c == '0') {
                zeros++;
            } else if (c == '1') {
                time = Math.max(time + 1, zeros);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        String color = "0101";

        System.out.println(swapTime(color));
    }
}
