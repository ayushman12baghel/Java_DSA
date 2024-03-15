public class Squares_of_sorted_array {
    public static int[] SortedSquares(int arr[]) {
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length - 1;
        while (left <= right) {
            if (arr[left] > arr[right]) {
                result[index] = arr[left];
                left++;
            } else {
                result[index] = arr[right];
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { -4, -1, 0, 3, 10 };
        arr = SortedSquares(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
