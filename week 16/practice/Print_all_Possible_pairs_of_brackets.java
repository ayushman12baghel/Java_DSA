public class Print_all_Possible_pairs_of_brackets {
    static int count = 0;

    public static void printParenthesisUtil(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println(++count);
            return;
        } else {
            if (open > close) {
                str[pos] = '}';
                printParenthesisUtil(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '{';
                printParenthesisUtil(str, pos + 1, n, open + 1, close);
            }
        }
    }

    public static void printParenthesis(int n, char str[]) {
        if (n > 0) {
            printParenthesisUtil(str, 0, n, 0, 0);
        }
    }

    public static void main(String args[]) {
        int n = 4;
        char str[] = new char[2 * n];
        printParenthesis(n, str);
    }
}
