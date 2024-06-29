public class SubArraySumEqualsK {
    public static int SubarraySumEqualsK(int arr[], int k) {
        int count = 0;
        int currSum = 0;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (i == 0) {
                    currSum = prefix[j];
                } else {
                    currSum = prefix[j] - prefix[i - 1];
                }
                
                if (currSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int k = 3;
        System.out.println(SubarraySumEqualsK(arr, k));
    }
}
