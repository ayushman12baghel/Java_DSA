public class Median_of_two_Sorted_Array {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums3[] = new int[nums1.length + nums2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums3[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums3[k++] = nums2[j++];
        }

        int mid = nums3.length / 2;
        if (nums3.length % 2 != 0) {
            return (double) nums3[mid];
        } else {
            return (double) (nums3[mid] + nums3[mid - 1]) / 2;
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int lo = 0;
        int hi = nums1.length;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int R1 = mid1 == n ? Integer.MAX_VALUE : nums1[mid1];
            int L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int R2 = mid2 == m ? Integer.MAX_VALUE : nums2[mid2];

            if (L1 <= R2 && L2 <= R1) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return (double) Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                hi = mid1 - 1;
            } else {
                lo = mid1 + 1;
            }
        }
        return (double) 0;
    }

    public static void main(String args[]) {
        int nums1[] = { 1, 2 }, nums2[] = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
