import java.util.*;

public class Merge_Two_2D_Arrays_by_Summing_their_values {

    // Using TreeMap O(nlogn)
    // Approach 1:
    public static int[][] mergeArrays2(int nums1[][], int nums2[][]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num[] : nums1) {
            map.put(num[0], num[1]);
        }

        for (int num[] : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        List<int[]> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[] { entry.getKey(), entry.getValue() });
        }

        int ans[][] = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    // Same Approach but more readable code
    public static int[][] mergeArrays(int nums1[][], int nums2[][]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num[] : nums1) {
            map.put(num[0], num[1]);
        }

        for (int num[] : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        List<int[]> list = new ArrayList<>();

        for (int key : map.keySet()) {
            list.add(new int[] { key, map.get(key) });
        }

        return list.toArray(new int[0][]);
    }

    // Approach 2 Two pointers O(n)
    public static int[][] mergeArrays3(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] > nums2[j][0]) {
                list.add(new int[] { nums2[j][0], nums2[j][1] });
                j++;
            } else {
                list.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            }
        }

        while (i < nums1.length) {
            list.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }

        while (j < nums2.length) {
            list.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String args[]) {
        int nums1[][] = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int nums2[][] = { { 1, 4 }, { 3, 2 }, { 4, 1 } };

        int ans[][] = mergeArrays(nums1, nums2);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
        System.out.println("Approach 2");
        int ans2[][] = mergeArrays2(nums1, nums2);

        for (int i = 0; i < ans2.length; i++) {
            System.out.println(ans2[i][0] + " " + ans2[i][1]);
        }
        System.out.println("Approach 3");
        int ans3[][] = mergeArrays3(nums1, nums2);

        for (int i = 0; i < ans3.length; i++) {
            System.out.println(ans3[i][0] + " " + ans3[i][1]);
        }
    }
}
