import java.util.*;

public class Make_Lexicographical_Smallest_Array_by_Swapping {

    // Brute Force (TLE)
    public static int[] lexicographicallySmallestArray(int nums[], int limit) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (true) {
                int smallest = nums[i];
                int index = -1;

                for (int j = i + 1; j < n; j++) {
                    if (smallest > nums[j] && Math.abs(smallest - nums[j]) <= limit) {
                        smallest = nums[j];
                        index = j;
                    }
                }

                if (index != -1) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }

    // Sorting and Grouping O(N log N);
    public static int[] lexicographicallySmallestArray2(int nums[], int limit) {
        int n = nums.length;
        int sorted[] = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted);
        int groupNumber = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(sorted[0], groupNumber);
        groupToList.computeIfAbsent(groupNumber, k -> new LinkedList()).add(sorted[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(sorted[i] - sorted[i - 1]) > limit) {
                groupNumber++;
            }

            numToGroup.put(sorted[i], groupNumber);
            groupToList.computeIfAbsent(groupNumber, k -> new LinkedList()).add(sorted[i]);
        }

        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            ans[i] = groupToList.get(group).remove(0);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 5, 3, 9, 8 };
        int limit = 2;
        int ans[] = lexicographicallySmallestArray(nums, limit);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int nums2[] = { 1, 5, 3, 9, 8 };
        int ans2[] = lexicographicallySmallestArray2(nums2, limit);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
