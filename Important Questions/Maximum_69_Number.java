import java.util.*;

public class Maximum_69_Number {

    public static int maximum69Number(int num) {
        char digits[] = String.valueOf(num).toCharArray();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        int num = 9996;

        System.out.println(maximum69Number(num));
    }
}
