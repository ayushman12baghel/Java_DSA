public class Check_if_Number_is_Sum_Of_Powers_of_Three {

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

    public static void main(String args[]) {
        int n = 91;
        System.out.println(isSumOfPowersOfThree(n));
        System.out.println(isSumOfPowersOfThree2(n));
    }
}
