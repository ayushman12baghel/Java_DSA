import java.util.*;

public class C_Hamburgers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ab = sc.nextInt();
        int as = sc.nextInt();
        int ac = sc.nextInt();
        int pb = sc.nextInt();
        int ps = sc.nextInt();
        int pc = sc.nextInt();

        long money = sc.nextLong();

        int arr[] = new int[3];

        for (char c : str.toCharArray()) {
            if (c == 'B') {
                arr[0]++;
            } else if (c == 'S') {
                arr[1]++;
            } else {
                arr[2]++;
            }
        }

        long left = 0;
        long right = (long) 1e13;
        long ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long needB = Math.max(0, mid * arr[0] - ab);
            long needS = Math.max(0, mid * arr[1] - as);
            long needC = Math.max(0, mid * arr[2] - ac);

            long cost = needB * pb + needS * ps + needC * pc;

            if (cost <= money) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}