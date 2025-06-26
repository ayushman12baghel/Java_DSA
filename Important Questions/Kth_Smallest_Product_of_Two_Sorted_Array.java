import java.util.*;

public class Kth_Smallest_Product_of_Two_Sorted_Array {

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long result = 0;
        long left = -10000000000L; // Smallest Product
        long right = 10000000000L; // Largest Product

        while (left <= right) {
            long midProduct = left + (right - left) / 2;

            long countSmallest = findCountSmallest(nums1, nums2, midProduct);

            if (countSmallest >= k) {
                result = midProduct;
                right = midProduct - 1;
            } else {
                left = midProduct + 1;
            }
        }

        return result;
    }

    public static long findCountSmallest(int nums1[], int nums2[], long midProduct) {
        long productsCount = 0;
        int n = nums2.length;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] >= 0) {
                int left = 0, right = n - 1, m = -1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    long product = (long) nums1[i] * nums2[mid];

                    if (product <= midProduct) {
                        m = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                productsCount += (m + 1);
            } else {
                int left = 0, right = n - 1, m = n;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    long product = (long) nums1[i] * nums2[mid];

                    if (product <= midProduct) {
                        m = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                productsCount += (n - m);
            }
        }

        return productsCount;
    }

    public static void main(String[] args) {
        int nums1[] = { -2, -1, 0, 1, 2 };
        int nums2[] = { -3, -1, 2, 4, 5 };
        int k = 3;

        System.out.println(kthSmallestProduct(nums1, nums2, k));
    }
}
