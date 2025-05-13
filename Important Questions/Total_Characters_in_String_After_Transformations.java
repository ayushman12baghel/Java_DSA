import java.util.*;

public class Total_Characters_in_String_After_Transformations {

    public static int lengthAfterTransformations(String str, int t) {
        int mod = 1000000007;
        int map[] = new int[26];

        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int temp[] = new int[26];

            for (int j = 0; j < 26; j++) {
                if (map[j] == 0) {
                    continue;
                }
                char key = (char) ('a' + j);
                int value = map[j];

                if (key == 'z') {
                    temp[0] = (temp[0] + value) % mod;
                    temp[1] = (temp[1] + value) % mod;
                } else {
                    temp[(key + 1) - 'a'] = (temp[(key + 1) - 'a'] + value) % mod;
                }
            }

            map = temp;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            count = (count + map[i]) % mod;
        }

        return count;
    }

    public static void main(String args[]) {
        String str = "abcyy";
        int t = 2;

        System.out.println(lengthAfterTransformations(str, t));
    }
}
