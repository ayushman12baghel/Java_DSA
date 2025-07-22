import java.util.*;

public class Number_of_Flowers_in_Full_Bloom {

    // Approach Using Sorting and BinarySearch
    public static int[] fullBloomFlowers(int flowers[][], int people[]) {
        int n = flowers.length;
        int m = people.length;

        int start[] = new int[n];
        int end[] = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int ans[] = new int[m];

        for (int i = 0; i < m; i++) {
            ans[i] = binarySearchEqual(start, people[i]) - binarySearchSmaller(end, people[i]);
        }

        return ans;
    }

    public static int binarySearchEqual(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int binarySearchSmaller(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int flowers[][] = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int people[] = { 2, 3, 7, 11 };

        int ans[] = fullBloomFlowers(flowers, people);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
