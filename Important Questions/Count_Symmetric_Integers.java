import java.util.*;

public class Count_Symmetric_Integers {

    // Approach 1 By converting to string
    public static int countSymmetricIntegers(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            String current = Integer.toString(i);
            if (current.length() % 2 != 0) {
                continue;
            }

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0, k = current.length() / 2; j < current.length() / 2 && k < current.length(); j++, k++) {
                leftSum += current.charAt(j) - '0';
                rightSum += current.charAt(k) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }

    // Approch 2
    public static int countSymmetricIntegers2(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            if (i >= 10 && i <= 99 && i % 11 == 0) {
                count++;
            } else if (i >= 1000 && i <= 9999) {
                int firstDigit = i / 1000;
                int secondDigit = i / 100 % 10;
                int thirdDigit = i / 10 % 10;
                int fourthDigit = i % 10;

                if (firstDigit + secondDigit == (thirdDigit + fourthDigit)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int low = 1200;
        int high = 1230;

        System.out.println(countSymmetricIntegers(low, high));
        System.out.println(countSymmetricIntegers2(low, high));
    }
}
