public class Modified_Fibonacci {
    public static int fibonacci(int n, int fib[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) {// fib[n] is already calculated
            return fib[n];
        }
        fib[n] = fibonacci(n - 1, fib) + fibonacci(n - 2, fib);
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n + 1];
        System.out.println(fibonacci(n, f));
    }
}