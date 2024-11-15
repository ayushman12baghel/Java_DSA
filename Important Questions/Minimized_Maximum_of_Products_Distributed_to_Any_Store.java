public class Minimized_Maximum_of_Products_Distributed_to_Any_Store {

    public static boolean isPossibleToDist(int x, int quantities[], int n) {
        for (int num : quantities) {
            n -= (num + x - 1) / x;
            if (n < 0) {
                return false;
            }
        }

        return true;
    }

    public static int minimizedMaximum(int quantities[], int n) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        int result = 0;

        for (int num : quantities) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToDist(mid, quantities, n)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int quantities[] = { 15, 10, 10 };
        int n = 7;

        System.out.println(minimizedMaximum(quantities, n));
    }
}
