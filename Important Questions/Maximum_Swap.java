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

    public static void main(String args[]) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }
}