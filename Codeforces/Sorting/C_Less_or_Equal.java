import java.util.*;

public class C_Less_or_Equal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        if (k == 0) {
            System.out.println(nums[0] == 1 ? -1 : nums[0] - 1);
        } else if (k == n || nums[k - 1] != nums[k]) {
            System.out.println(nums[k - 1]);
        } else {
            System.out.println(-1);
        }
    }
}