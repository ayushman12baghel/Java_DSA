import java.util.*;

public class Defanging_an_IP_Address {

    public static String defangIPaddr(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "255.100.50.0";
        System.out.println(defangIPaddr(str));
    }
}
