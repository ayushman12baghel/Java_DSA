import java.util.*;
import java.util.LinkedList;

public class Sliding_Puzzle {

    public static int slidingPuzzle(int board[][]) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(sb.toString());
        visited.add(sb.toString());

        int directions[][] = { { 1, 3 }, { 2, 4, 0 }, { 5, 1 }, { 4, 0 }, { 3, 5, 1 }, { 4, 2 } };
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return moves;
                }
                int zeroPos = curr.indexOf('0');

                for (int newPos : directions[zeroPos]) {
                    String next = swap(curr, zeroPos, newPos);
                    if (visited.contains(next)) {
                        continue;
                    }

                    visited.add(next);
                    queue.offer(next);
                }
            }
            moves++;
        }

        return -1;
    }

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));

        return sb.toString();
    }

    public static void main(String args[]) {
        int board[][] = { { 4, 1, 2 }, { 5, 0, 3 } };

        System.out.println(slidingPuzzle(board));

    }
}
