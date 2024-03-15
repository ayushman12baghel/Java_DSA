import java.util.HashSet;

public class Minimum_common_value_in_sorted_arrays {
    // method 1
    // public static int getCommon(int arr[], int nums[]) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int num : arr) {
    // set.add(num);
    // }
    // for (int num : nums) {
    // if (set.contains(num)) {
    // return num;
    // }
    // }
    // return -1;
    // }

    // method 2
    // public static int getCommon(int arr[], int nums[]) {
    // int first = 0;
    // int second = 0;
    // while (first < arr.length && second < nums.length) {
    // if (arr[first] > nums[second]) {
    // second++;
    // } else if (arr[first] < nums[second]) {
    // first++;
    // } else {
    // return arr[first];
    // }
    // }
    // return -1;
    // }

    // method 3
    public static boolean binarySearch(int target, int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static int getCommon(int arr[], int nums[]) {
        if (arr.length > nums.length) {
            return getCommon(nums, arr);
        }

        for (int num : arr) {
            if (binarySearch(num, nums)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 6 };
        int nums[] = { 2, 3, 4, 5 };
        System.out.println(getCommon(arr, nums));
    }
}
