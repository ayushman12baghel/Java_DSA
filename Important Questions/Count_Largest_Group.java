import java.util.*;

public class Count_Largest_Group {

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxSize = 1;

        for (int i = 1; i <= n; i++) {
            int digitSum = findSum(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
            if (map.get(digitSum) == maxSize) {
                count++;
            } else if (map.get(digitSum) > maxSize) {
                maxSize = map.get(digitSum);
                count = 1;
            }
        }

        return count;
    }

    public static int findSum(int n) {
        int sum = 0;
        while (n > 0) {
            int ld = n % 10;
            sum += ld;
            n /= 10;
        }

        return sum;
    }

    public static void main(String args[]) {
        int n = 13;

        System.out.println(countLargestGroup(n));
    }
}
