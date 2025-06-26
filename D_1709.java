import java.util.*;

public class D_1709 {

    static class Operations {
        int type;
        int index;

        public Operations(int type, int index) {
            this.type = type;
            this.index = index;
        }

        @Override
        public String toString() {
            return type + " " + index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            List<Operations> ans = new ArrayList<>();

            // Step 1: Fix a[i] < b[i]
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) {
                    int temp = a[i];
                    a[i] = b[i];
                    b[i] = temp;
                    ans.add(new Operations(3, i + 1));
                }
            }

            // Step 2: Sort both arrays using adjacent swaps
            // Bubble sort a[]
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        // Swap in a[]
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;

                        // Swap in b[] as well to preserve a[i] < b[i] condition
                        temp = b[j];
                        b[j] = b[j + 1];
                        b[j + 1] = temp;

                        ans.add(new Operations(1, j + 1));
                    }
                }
            }

            // Now sort b[] independently if needed
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (b[j] > b[j + 1]) {
                        int temp = b[j];
                        b[j] = b[j + 1];
                        b[j + 1] = temp;
                        ans.add(new Operations(2, j + 1));
                    }
                }
            }

            // Output
            System.out.println(ans.size());
            for (Operations op : ans) {
                System.out.println(op);
            }
        }
    }
}
