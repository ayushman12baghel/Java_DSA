import java.util.*;

public class Check_If_Any_Element_has_Prime_Frequence {

    public static boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxFreq = 0;
        for (int value : map.values()) {
            maxFreq = Math.max(maxFreq, value);
        }

        boolean isPrime[] = new boolean[maxFreq + 1];
        fillPrime(maxFreq, isPrime);

        for (int value : map.values()) {
            if (isPrime[value]) {
                return true;
            }
        }

        return false;
    }

    // Sieve of Eratosthenes Method
    public static void fillPrime(int n, boolean isPrime[]) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 4 };

        System.out.println(checkPrimeFrequency(nums));
    }
}
