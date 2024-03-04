public class binary_strings_problem {
    public static void printBinaryStringd(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        printBinaryStringd(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinaryStringd(n - 1, 1, str + "1");
        }
    }

    public static void main(String args[]) {
        printBinaryStringd(3, 0, "");
    }
}
