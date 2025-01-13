import java.util.*;

public class Minimum_Length_of_String_After_Operations {

    public static int minimumLength(String str) {
        int freq[] = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] % 2 == 0) {
                count += 2;
            } else {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        String str = "abaacbcbb";
        System.out.println(minimumLength(str));
    }
}
