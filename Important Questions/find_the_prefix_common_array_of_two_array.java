public class find_the_prefix_common_array_of_two_array {

    // O(n2)
    public static int[] findThePrefixCommonArray(int A[], int B[]) {
        int ans[] = new int[A.length];
        int freq[] = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            int count = 0;

            for (int j = 0; j < freq.length; j++) {
                if (freq[j] == 2) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    // O(n)
    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int ans[] = new int[A.length];
        int count = 0;
        int freq[] = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                count++;
            }
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                count++;
            }

            ans[i] = count;
        }

        return ans;
    }

    public static void main(String args[]) {
        int A[] = { 1, 3, 2, 4 };
        int B[] = { 3, 1, 2, 4 };

        int ans[] = findThePrefixCommonArray(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
