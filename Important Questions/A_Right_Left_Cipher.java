import java.util.*;

public class A_Right_Left_Cipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        int mid = str.length() / 2;
        int left = mid - 1;
        int right = mid;
        if (str.length() % 2 != 0) {
            left = mid;
            right = mid + 1;
        }
        boolean canTakeLeft = true;

        while (left >= 0 && right < str.length()) {
            if (canTakeLeft) {
                sb.append(str.charAt(left));
                left--;
                canTakeLeft = false;
            } else {
                sb.append(str.charAt(right));
                right++;
                canTakeLeft = true;
            }
        }

        while (left >= 0) {
            sb.append(str.charAt(left));
            left--;
        }
        while (right < str.length()) {
            sb.append(str.charAt(right));
            right++;
        }

        System.out.println(sb.toString());
    }
}