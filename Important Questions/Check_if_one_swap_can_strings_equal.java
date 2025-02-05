import java.util.*;

public class Check_if_one_swap_can_strings_equal {

    // Approach 1
    public static boolean areAlmostEqual(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                list.add(i);
            }
        }

        if (list.size() != 2) {
            return false;
        }

        char arr[] = str1.toCharArray();

        char temp = arr[list.get(0)];
        arr[list.get(0)] = arr[list.get(1)];
        arr[list.get(1)] = temp;

        return new String(arr).equals(str2);
    }

    // Approach 2
    public static boolean areAlmostEqual2(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        int index1 = 0;
        int index2 = 0;
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                } else if (count == 1) {
                    index1 = i;
                } else {
                    index2 = i;
                }
            }
        }

        return str1.charAt(index1) == str2.charAt(index2) && str2.charAt(index1) == str1.charAt(index2);
    }

    public static void main(String args[]) {
        String s1 = "bank", s2 = "kanb";

        System.out.println(areAlmostEqual(s1, s2));
        System.out.println(areAlmostEqual2(s1, s2));
    }
}
