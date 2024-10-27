public class Find_the_Pivot_Integer {

    public static int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = 0;

            for (int j = 1; j <= i; j++) {
                left += j;
            }

            for (int j = i; j <= n; j++) {
                right += j;
            }

            if (left == right) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotInteger2(int n) {
        int total = 0;
        int left = 0;

        for (int i = 1; i <= n; i++) {
            total += i;
        }

        for (int i = 1; i <= n; i++) {
            if (left == (total - left - i)) {
                return i;
            }
            left += i;
        }

        return -1;
    }

    public static void main(String args[]) {
        int n = 8;
        System.out.println(pivotInteger(n));
        System.out.println(pivotInteger2(n));
    }
}
