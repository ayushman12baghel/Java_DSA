import java.util.*;

public class Move_Pieces_to_Obtain_String {

    // Approach 1 Using Brute Force Checking all States O(n)*n!
    // Very High T.L.E and also give memory Limit Exceed
    public static boolean canChange(String start, String target) {
        Map<String, Boolean> map = new HashMap<>();

        return solve(new StringBuilder(start), new StringBuilder(target), start.length(), map);
    }

    public static boolean solve(StringBuilder start, StringBuilder target, int n, Map<String, Boolean> map) {
        if (start.toString().equals(target.toString())) {
            return true;
        }

        if (map.containsKey(start.toString())) {
            return map.get(start.toString());
        }

        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == 'L' && i > 0 && start.charAt(i - 1) == '_') {
                swap(start, i, i - 1);
                if (solve(start, target, n, map)) {
                    return true;
                }

                swap(start, i - 1, i);
            } else if (start.charAt(i) == 'R' && i < n - 1 && start.charAt(i + 1) == '_') {
                swap(start, i, i + 1);
                if (solve(start, target, n, map)) {
                    return true;
                }

                swap(start, i + 1, i);
            }
        }

        map.put(start.toString(), false);

        return false;
    }

    public static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    // Approach 2 Using 2 Pointers O(n)
    public static boolean canChange2(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            if (start.charAt(j) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static void main(String args[]) {
        String start = "_L__R__R_";
        String target = "L______RR";

        System.out.println(canChange(start, target));
        System.out.println(canChange2(start, target));
    }
}
