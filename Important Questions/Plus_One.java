public class Plus_One {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            int digit = digits[i];

            if (digit < 9) {
                digits[i] = digit + 1;

                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int newNumber[] = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    // If the array has starting zeros
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            int digit = digits[i];

            if (digit < 9) {
                digits[i] += 1;

                int firstIndex = 0;
                while (firstIndex < n && digits[firstIndex] == 0) {
                    firstIndex++;
                }

                if (firstIndex == 0) {
                    return digits;
                }

                int ans[] = new int[n - firstIndex];

                for (int j = 0; j < ans.length; j++) {
                    ans[j] = digits[j + firstIndex];
                }

                return ans;
            } else {
                digits[i] = 0;
            }
        }

        int newNumber[] = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String args[]) {
        int arr[] = { 9, 9, 9, 9 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int x[] = plusOne(arr);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
