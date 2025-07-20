import java.util.*;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    // Approach Using Memoisation
    public static int maxLength(List<String> arr) {
        Map<String, Integer> map = new HashMap<>();

        return solve(arr, 0, "", map);
    }

    public static int solve(List<String> arr, int index, String temp, Map<String, Integer> map) {
        if (index >= arr.size()) {
            return temp.length();
        }

        String key = index + "," + temp;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int include = 0;
        int exclude = solve(arr, index + 1, temp, map);

        if (canAppend(temp, arr.get(index))) {
            include = solve(arr, index + 1, temp + arr.get(index), map);
        }

        int result = Math.max(include, exclude);
        map.put(key, result);

        return result;
    }

    public static boolean canAppend(String str1, String str2) {
        Set<Character> set = new HashSet<>();

        for (char c : str1.toCharArray()) {
            set.add(c);
        }

        for (char c : str2.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            if (!set.add(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        System.out.println(maxLength(arr));
    }
}
