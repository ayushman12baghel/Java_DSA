import java.util.*;

public class Rotate_String {

    public static boolean rotateString(String str, String goal) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            if (sb.toString().equals(goal)) {
                return true;
            }
            sb.deleteCharAt(0);
            sb.append(str.charAt(i));
        }

        return false;
    }

    public static void main(String args[]) {
        String str = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(str, goal));
    }
}
