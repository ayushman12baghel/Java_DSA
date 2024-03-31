public class CountSUbarraysWithFixedBounds {
    public static int countSubarrays(int arr[], int min, int max) {
        int n = arr.length;
        int jmax = -1;
        int jmin = -1;
        int jbad = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max || arr[i] < min) {
                jbad = i + 1;
                jmax = -1;
                jmin = -1;
            } else {
                if (arr[i] == min) {
                    jmin = i;
                }
                if (arr[i] == max) {
                    jmax = i;
                }
            }
            result += Math.max(0, Math.min(jmax, jmin) - jbad + 1);
        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 2, 7, 5 };
        int min = 1;
        int max = 5;
        System.out.println(countSubarrays(arr, min, max));
    }
}
