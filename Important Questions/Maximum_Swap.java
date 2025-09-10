import java.util.*;

public class Maximum_Swap {

    public static int maximumSwap(int num) {
        char arr[] = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                char c = arr[i];
                arr[i] = arr[index];
                arr[index] = c;
                String str = new String(arr);
                return Integer.parseInt(str);
            }
        }

        return num;
    }

    // Another Way
    public static int maximumSwap2(int num) {
        char digits[] = String.valueOf(num).toCharArray();
        int n = digits.length;
        int rightMax[] = new int[n];
        rightMax[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[rightMax[i + 1]]) {
                rightMax[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (digits[i] < digits[rightMax[i]]) {
                char temp = digits[i];
                digits[i] = digits[rightMax[i]];
                digits[rightMax[i]] = temp;

                return Integer.parseInt(new String(digits));
            }
        }

        return num;
    }

    public static void main(String args[]) {
        int num = 2736;
        System.out.println(maximumSwap(num));
        System.out.println(maximumSwap2(num));
    }
}