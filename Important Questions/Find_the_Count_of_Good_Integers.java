import java.util.*;

public class Find_the_Count_of_Good_Integers {

    public static long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();

        int d = (n + 1) / 2;
        int start = (int) Math.pow(10, d - 1);
        int end = (int) Math.pow(10, d) - 1;

        for (int i = start; i <= end; i++) {
            String leftHalf = Integer.toString(i);
            String full;

            if (n % 2 == 0) {
                String rightHalf = new StringBuilder(leftHalf).reverse().toString();
                full = leftHalf + rightHalf;
            } else {
                String righHalf = new StringBuilder(leftHalf.substring(0, d - 1)).reverse().toString();
                full = leftHalf + righHalf;
            }

            long number = Long.parseLong(full);

            if (number % k != 0) {
                continue;
            }

            char chars[] = full.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }

        long result = 0;

        long factorial[] = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (String str : set) {
            int count[] = new int[10];
            for (char c : str.toCharArray()) {
                count[c - '0']++;
            }

            int zeroCount = count[0];
            int nonZeroCount = str.length() - zeroCount;

            long permutation = nonZeroCount * factorial[str.length() - 1];

            for (int i = 0; i < 10; i++) {
                permutation /= factorial[count[i]];
            }

            result += permutation;
        }

        return result;
    }

    public static void main(String args[]) {
        int n = 3;
        int k = 5;

        System.out.println(countGoodIntegers(n, k));
    }
}
