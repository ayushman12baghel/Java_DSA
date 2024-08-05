import java.util.*;

public class Kth_Distinct_String_in_Array {

    public static String kthDistinct(String arr[], int k) {
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], false);
            } else {
                map.put(arr[i], true);
            }
        }

        for (String x : arr) {
            if (map.get(x)) {
                count++;
                if (count == k) {
                    return x;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String arr[] = { "d", "b", "c", "b", "c", "a" };
        int k = 2;

        System.out.println(kthDistinct(arr, k));
    }
}
