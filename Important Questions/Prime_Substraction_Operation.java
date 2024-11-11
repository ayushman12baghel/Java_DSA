import java.util.*;

public class Prime_Substraction_Operation {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean primeSubOperation(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        boolean primes[] = new boolean[max + 1];
        for (int i = 0; i < primes.length; i++) {
            if (isPrime(i)) {
                primes[i] = true;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            for (int p = 2; p < nums[i]; p++) {
                if (!primes[p]) {
                    continue;
                }
                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // Beats 100%
    public static boolean primeSubOperation2(int nums[]) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        boolean primes[] = new boolean[max + 1];
        Arrays.fill(primes, true);
        isPrime(primes);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            for (int p = 2; p < nums[i]; p++) {
                if (!primes[p]) {
                    continue;
                }
                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void isPrime(boolean primes[]) {
        for (int i = 2; i * i <= primes.length; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 4, 9, 6, 10 };

        System.out.println(primeSubOperation(nums));
        System.out.println(primeSubOperation2(nums));
    }
}
