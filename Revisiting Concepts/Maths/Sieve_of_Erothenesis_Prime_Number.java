import java.util.*;

boolean[] isPrime = new boolean[163];

void computePrimes() {
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= 162; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= 162; j += i) {
                isPrime[j] = false;
            }
        }
    }
}
