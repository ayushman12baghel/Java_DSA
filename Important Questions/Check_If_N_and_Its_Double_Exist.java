import java.util.*;

public class Check_If_N_and_Its_Double_Exist {

    public static boolean checkIfExists(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkIfExists2(int arr[]) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2) || arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 2, 5, 3 };

        System.out.println(checkIfExists(arr));
        System.out.println(checkIfExists2(arr));
    }
}
