import java.util.*;

//Approach O(nums.length * (num^1/2))
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int divCount = 0;
            int divSum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    if (d1 == d2) {
                        divCount++;
                        divSum += d1;
                    } else {
                        divCount += 2;
                        divSum += d1 + d2;
                    }

                    if (divCount > 4)
                        break;
                }
            }

            if (divCount == 4) {
                sum += divSum;
            }
        }

        return sum;
    }
}
