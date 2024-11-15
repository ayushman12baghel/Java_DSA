public class Shortest_Subarray_to_Removed_to_Make_Array_Sorted {

    public static int findLengthOfShortestSubarray(int arr[]) {
        int n = arr.length;
        int j = n - 1;

        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        int result = j;
        int i = 0;

        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) {
            while (j < n && arr[i] > arr[j]) {
                j++;
            }

            result = Math.min(result, j - i - 1);
            i++;
        }

        return result;
    }

    public static void main(String srgs[]) {
        int arr[] = { 1, 2, 3, 10, 4, 2, 3, 5 };

        System.out.println(findLengthOfShortestSubarray(arr));
    }
}
