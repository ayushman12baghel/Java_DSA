import java.util.*;

//Approach Using Backtracking  O(k^(N*N))
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for (String str : allowed) {
            String key = str.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str.charAt(str.length() - 1));
        }

        return solve(bottom, map, new StringBuilder(), 0);
    }

    public boolean solve(String bottom, Map<String, List<Character>> map, StringBuilder sb, int index) {
        if (bottom.length() == 1) {
            return true;
        }

        if (sb.length() + 1 == bottom.length()) {
            return solve(sb.toString(), map, new StringBuilder(), 0);
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) {
            return false;
        }

        for (char c : map.get(key)) {
            sb.append(c);
            if (solve(bottom, map, sb, index + 1)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}

// Approach 2 Memoisation
// Time Complexity:

// $O(A^N) A: The size of the alphabet (e.g., if allowed characters are 'A'
// through 'F', A = 6).N: The length of the bottom string.
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        Set<String> failed = new HashSet<>();

        for (String str : allowed) {
            String key = str.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str.charAt(str.length() - 1));
        }

        return solve(bottom, map, new StringBuilder(), 0, failed);
    }

    public boolean solve(String bottom, Map<String, List<Character>> map, StringBuilder sb, int index,
            Set<String> failed) {
        if (bottom.length() == 1) {
            return true;
        }

        if (index == 0 && failed.contains(bottom)) {
            return false;
        }

        if (sb.length() + 1 == bottom.length()) {
            boolean result = solve(sb.toString(), map, new StringBuilder(), 0, failed);
            if (!result) {
                failed.add(bottom);
            }

            return result;
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) {
            failed.add(bottom);
            return false;
        }

        for (char c : map.get(key)) {
            sb.append(c);
            if (solve(bottom, map, sb, index + 1, failed)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        failed.add(bottom);

        return false;
    }
}