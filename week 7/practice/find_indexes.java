public class find_indexes {
    public static void findIndex(int arr[], int key, int index) {
        if (index >= arr.length) {
            return;
        }
        if (arr[index] == key) {
            System.out.print(index + " ");
        }
        findIndex(arr, key, index + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 13, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        findIndex(arr, key, 0);
    }
}
