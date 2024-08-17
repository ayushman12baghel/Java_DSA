public class Catalan_Number {

    public static int calatanRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += calatanRecursion(i) * calatanRecursion(n - i - 1);
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(calatanRecursion(n));
    }
}
