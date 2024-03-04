import java.util.*;

public class max_subarray_sum_not_efficient {
    public static void max_sum(int numbers[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += numbers[k];
                    if (maximum < sum) {
                        maximum = sum;
                    }
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
        System.out.println("The maximum sum is: " + maximum);
    }

    public static void main(String args[]) {
        int numbers[] = { 1, -2, 6, -1, 3 };
        max_sum(numbers);
    }
}
