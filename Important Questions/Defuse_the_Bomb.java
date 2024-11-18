public class Defuse_the_Bomb {

    public static int[] decrypt(int code[], int k) {
        int ans[] = new int[code.length];

        if (k == 0) {
            return ans;
        } else if (k > 0) {
            for (int i = 0; i < ans.length; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                ans[i] = sum;
            }
        } else {
            for (int i = 0; i < ans.length; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
                ans[i] = sum;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int code[] = { 2, 4, 9, 3 };
        int k = -2;

        int ans[] = decrypt(code, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
