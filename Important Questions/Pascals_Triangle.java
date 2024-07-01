import java.util.*;

public class Pascals_Triangle {

    public static List<List<Integer>> generate(int rows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);

        for (int i = 1; i < rows; i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }

            curr.add(1);
            triangle.add(curr);
        }

        return triangle;
    }

    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> triangle = generate(5);
        printTriangle(triangle);
    }
}
