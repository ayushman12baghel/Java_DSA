import java.util.*;

public class Sort_by_Absolute_Difference {

    public static void rearrange(int[] arr, int x) {
        Integer temp[] = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> Math.abs(x - a) - Math.abs(x - b));

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int nums[] = { 10, 5, 3, 9, 2 };
        int x = 7;

    }
}
