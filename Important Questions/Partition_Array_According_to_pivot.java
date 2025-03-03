import java.util.ArrayList;
import java.util.List;

public class Partition_Array_According_to_pivot {

    // Using Differnet Lists to apend the elements
    public static int[] pivotArray(int nums[], int pivot) {
        List<Integer> less = new ArrayList<>();
        int count = 0;
        List<Integer> greater = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (pivot == nums[i]) {
                count++;
            } else if (pivot > nums[i]) {
                less.add(nums[i]);
            } else {
                greater.add(nums[i]);
            }
        }

        int ans[] = new int[nums.length];
        int i = 0;

        for (int num : less) {
            ans[i++] = num;
        }

        for (int j = 0; j < count; j++) {
            ans[i++] = pivot;
        }

        for (int num : greater) {
            ans[i++] = num;
        }

        return ans;
    }

    // Approach 2 Usng fixed array ans
    public static int[] pivotArray2(int nums[], int pivot) {
        int lessCount = 0;
        int pivotCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                lessCount++;
            } else if (nums[i] == pivot) {
                pivotCount++;
            }
        }

        int ans[] = new int[nums.length];
        int start = 0;
        int mid = lessCount;
        int end = lessCount + pivotCount;

        for (int i = 0; i < ans.length; i++) {
            if (nums[i] < pivot) {
                ans[start++] = nums[i];
            } else if (nums[i] == pivot) {
                ans[mid++] = nums[i];
            } else {
                ans[end++] = nums[i];
            }
        }

        return ans;
    }

    // Approach 3 Using 2 Pointers
    public static int[] pivotArray3(int[] nums, int pivot) {
        int ans[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int i_ = 0;
        int j_ = nums.length - 1;

        while (i < nums.length && j >= 0) {
            if (nums[i] < pivot) {
                ans[i_++] = nums[i];
            }
            if (nums[j] > pivot) {
                ans[j_--] = nums[j];
            }

            i++;
            j--;
        }

        while (i_ <= j_) {
            ans[i_++] = pivot;
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;

        int ans[] = pivotArray(nums, pivot);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int ans2[] = pivotArray2(nums, pivot);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
        System.out.println();

        int ans3[] = pivotArray3(nums, pivot);
        for (int i = 0; i < ans3.length; i++) {
            System.out.print(ans3[i] + " ");
        }
    }
}
