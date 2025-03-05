public class Count_total_Numbers_of_Colored_Cells {

    public static long countColoredCells(int n) {
        if (n <= 1) {
            return n;
        }

        return (long) (Math.pow(n, 2) + Math.pow(n - 1, 2));
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(countColoredCells(n));
    }
}
