public class Koko_Eating_Bananas {

    public static boolean isPossible(int x, int piles[], int h) {
        for (int num : piles) {
            h -= (num + x - 1) / x;
            if (h < 0) {
                return false;
            }
        }

        return true;
    }

    public static int minEatingSpeed(int piles[], int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        int result = 0;

        for (int num : piles) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, piles, h)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int piles[] = { 30, 11, 23, 4, 20 };
        int h = 5;

        System.out.println(minEatingSpeed(piles, h));
    }
}
