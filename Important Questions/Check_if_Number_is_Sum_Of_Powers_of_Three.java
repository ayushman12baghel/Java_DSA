public class Check_if_Number_is_Sum_Of_Powers_of_Three {
    // Approach 1 Using Maths
    public static boolean isSumOfPowersOfThree(int n) {
        int power = 0;
        int temp = n;

        while (temp > 0) {
            temp /= 3;
            power++;
        }

        while (n > 0) {
            if (n >= Math.pow(3, power)) {
                n -= Math.pow(3, power);
            }
            if (n >= Math.pow(3, power)) {
                return false;
            }

            power--;
        }

        return true;
    }

    // Approach 2 Using Ternary Operator
    public static boolean isSumOfPowersOfThree2(int n) {
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            if (remainder == 2) {
                return false;
            }
        }

        return true;
    }

    // Approach 3 Using Backtracking
    public static boolean isSumOfPowersOfThree3(int n) {
        return solve(n, 0);
    }

    public static boolean solve(int n, int power) {
        if (n == 0) {
            return true;
        }

        if (Math.pow(3, power) > n) {
            return false;
        }

        boolean notTake = solve(n, power + 1);
        boolean take = solve(n -= Math.pow(3, power), power + 1);

        return notTake || take;
    }

    public static void main(String args[]) {
        int n = 91;
        System.out.println(isSumOfPowersOfThree(n));
        System.out.println(isSumOfPowersOfThree2(n));
        System.out.println(isSumOfPowersOfThree3(n));
    }
}
