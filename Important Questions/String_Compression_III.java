import java.util.*;

public class String_Compression_III {

    public static String compressedString(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int i = 0;

        while (i < n) {
            char ch = str.charAt(i);
            int count = 0;

            while (i < n && count < 9 && str.charAt(i) == ch) {
                count++;
                i++;
            }

            sb.append(count).append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaabb";

        System.out.println(compressedString(str));
    }
}
