public class Minimum_Number_of_merge_operations_to_make_array_palindrome {

    public static int minMergeOperations(int arr[]) {
        int ans = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] > arr[right]) {
                ans++;
                arr[right - 1] += arr[right];
                right--;
            } else {
                arr[left + 1] += arr[left];
                left++;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 4, 5, 1 };

        System.out.println(minMergeOperations(arr));
    }
}
