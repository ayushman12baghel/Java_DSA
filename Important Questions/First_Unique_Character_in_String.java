import java.util.*;

public class First_Unique_Character_in_String {

    public static int firstUniqChar(String str) {
        if (str.length() == 0) {
            return -1;
        }

        int freq[] = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        String str = "leetcode";

        System.out.println(firstUniqChar(str));
    }
}
