public class Minimum_Array_End {
    public static long minEnd(int n, int x) {
        if (n == 0 || x == 0) {
            return 0;
        }

        long ans = x;
        long temp = x;
        for (int i = 0; i < n; i++) {
            if (((temp) & x) == x) {
                ans = temp;
            } else {
                long y = x | temp;
                ans = y;
                temp = y;
            }
            temp++;
        }
        return ans;
    }

    public static long minEnd2(int n, int x) {
        long ans = x;

        for (int i = 1; i < n; i++) {
            ans = (ans + 1) | x;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 2, x = 7;

        System.out.println(minEnd(n, x));
        System.out.println(minEnd2(n, x));
    }
}
