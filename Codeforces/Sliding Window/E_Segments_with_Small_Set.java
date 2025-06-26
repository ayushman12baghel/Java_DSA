import java.util.*;

public class E_Segments_with_Small_Set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long ans = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
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