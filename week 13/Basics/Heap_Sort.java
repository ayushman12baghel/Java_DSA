import java.util.*;

public class Heap_Sort {

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(max)
    }

    public static void heapSort(int arr[]) {
        // step1 - build maxHeap
        int n = arr.length - 1;
        for (int i = n / 2; i >= 0; i++) {
            heapify(arr, i, n);
        }

        // step2 - push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest-frst with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3 };
    }
}
