import java.util.*;

public class Form_the_Largest_Number {

    public static String findLargest(int[] arr) {
        String s[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            s[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int nums[] = { 54, 546, 548, 60 };

        System.out.println(findLargest(nums));
    }
}
