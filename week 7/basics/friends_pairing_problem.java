import java.util.*;

public class friends_pairing_problem {
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // choice
        // single
        int fnm1 = friendsPairing(n - 1);

        // pair
        int fnm2 = friendsPairing(n - 2);
        int pairWays = fnm1 * fnm2;

        // totWays
        int totWays = fnm1 + pairWays;
        return totWays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        System.out.println(friendsPairing(a));
    }
}
