import java.util.*;

public class B_Number_of_Smaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int nums1[] = new int[n1];
        int nums2[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        int result[] = new int[n2];
        int k = 0;

        for (int i = 0; i < n2; i++) {
            while (k < n1 && nums1[k] < nums2[i]) {
                k++;
            }

            result[i] = k;
        }

        for (int i = 0; i < n2; i++) {
            System.out.print(result[i] + " ");
        }
    }
}