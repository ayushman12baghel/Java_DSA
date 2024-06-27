import java.util.*;

public class Count_Distinct_Elements {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> set = new HashSet<>();

        int ans = 0;
        for (int num : arr) {
            if (!set.contains(num)) {
                set.add(num);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
