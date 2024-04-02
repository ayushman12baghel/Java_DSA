public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        int map1[] = new int[200];
        int map2[] = new int[200];
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[s.charAt(i)]) {
                return false;
            }
            map1[s.charAt(i)] = i + 1;
            map2[s.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
}
