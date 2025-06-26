import java.util.*;

public class F_Segments_with_Small_Spread {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();

        long nums[] = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        long ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        System.out.println(ans);
    }
}