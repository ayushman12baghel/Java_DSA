import java.util.*;

public class Find_the_length_of_a_longest_common_prefix {

    public static int longestPrefix(int arr1[], int arr2[]) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int num : arr1) {
            String str = Integer.toString(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int length = 0;

        for (int num : arr2) {
            String str = Integer.toString(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                if (map.containsKey(prefix)) {
                    length = Math.max(prefix.length(), length);
                }
            }
        }

        return length;

    }

    public static void main(String args[]) {
        int arr1[] = { 1, 10, 100 };
        int arr2[] = { 1000 };

        System.out.println(longestPrefix(arr1, arr2));
    }
}
