import java.util.*;

public class Closest_prime_Number_in_range {

    // Approach 1 T.C O(n*sqrt(n))
    public static int[] closestPrimes(int left, int right) {
        if (left == 1) {
            left++;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < diff) {
                diff = list.get(i + 1) - list.get(i);
                num1 = list.get(i);
                num2 = list.get(i + 1);
            }
        }

        if (num1 == Integer.MAX_VALUE || num2 == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }

        return new int[] { num1, num2 };
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Approach 2 T.C O(nlog(log(n)))
    public static int[] closestPrimes2(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean prime[] = new boolean[right + 1];
        Arrays.fill(prime, true);
        isPrime(right, prime);
        if (left == 1) {
            left += 1;
        }

        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (diff <= 2)
                break;
            if (list.get(i + 1) - list.get(i) < diff) {
                num1 = list.get(i);
                num2 = list.get(i + 1);
                diff = list.get(i + 1) - list.get(i);
            }
        }

        if (num2 == Integer.MAX_VALUE || num1 == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }

        return new int[] { num1, num2 };
    }

    public static void isPrime(int n, boolean prime[]) {
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    // Approach 3 Early Stopping
    public static int[] closestPrimes3(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean prime[] = new boolean[right + 1];
        Arrays.fill(prime, true);
        isPrime(right, prime);
        if (left == 1) {
            left += 1;
        }

        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (list.size() != 0 && i - list.get(list.size() - 1) <= 2) {
                    return new int[] { list.get(list.size() - 1), i };
                }
                list.add(i);
            }
        }

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (diff <= 2) {
                break;
            }
            if (list.get(i + 1) - list.get(i) < diff) {
                num1 = list.get(i);
                num2 = list.get(i + 1);
                diff = list.get(i + 1) - list.get(i);
            }
        }

        if (num2 == Integer.MAX_VALUE || num1 == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }

        return new int[] { num1, num2 };
    }

    public static void main(String args[]) {
        int left = 11;
        int right = 19;

        int ans[] = closestPrimes(left, right);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        int ans2[] = closestPrimes2(left, right);

        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
        System.out.println();
        ans = closestPrimes3(left, right);

        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}