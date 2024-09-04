import java.util.*;

public class Valid_Anagram {

    public static boolean isAnagram(String s, String t) {
        char str[] = s.toCharArray();
        char str2[] = t.toCharArray();
        Arrays.sort(str);
        Arrays.sort(str2);

        return Arrays.equals(str, str2);
    }

    public static boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));
    }
}
