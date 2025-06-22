import java.util.*;

public class Divide_a_String_Into_Groups_of_Size_K {

    public static String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i += k) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < i + k && j < s.length(); j++) {
                temp.append(s.charAt(j));
            }

            while (temp.length() < k) {
                temp.append(fill);
            }

            list.add(temp.toString());
        }

        String ans[] = new String[list.size()];
        int i = 0;

        for (String temp : list) {
            ans[i++] = temp;
        }

        return ans;
    }

    public static void main(String args[]) {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        String ans[] = divideString(s, k, fill);

        for (String temp : ans) {
            System.out.println(temp);
        }
    }
}
