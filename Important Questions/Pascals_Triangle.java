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

    // practice
    public static List<List<Integer>> pascal(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);

        for (int i = 1; i < n; i++) {
            List<Integer> prev = list.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            list.add(curr);
        }

        return list;
    }

    public static void main(String args[]) {
        List<List<Integer>> triangle = generate(5);
        printTriangle(triangle);

        List<List<Integer>> list = pascal(5);
        printTriangle(list);
    }
}
