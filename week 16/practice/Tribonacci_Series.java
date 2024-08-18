public class Tribonacci_Series {
    public static int tribonacci(int n) {
        // int a=0,b=1,c=1,d;
        // if(n==0){
        // return 0;
        // }
        // if(n==1 || n==2){
        // return 1;
        // }

        // while(n-->2){
        // d=a+b+c;
        // a=b;
        // b=c;
        // c=d;
        // }

        // return c;
        if (n < 2) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.print(tribonacci(n));
    }
}