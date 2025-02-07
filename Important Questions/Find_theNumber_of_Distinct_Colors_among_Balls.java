import java.util.*;

public class Find_theNumber_of_Distinct_Colors_among_Balls {

    public static int[] distinctColors(int limit, int queries[][]) {
        int result[] = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                map.put(prevColor, map.getOrDefault(prevColor, 0) - 1);

                if (map.get(prevColor) == 0) {
                    map.remove(prevColor);
                }
            }

            ballMap.put(ball, color);
            map.put(color, map.getOrDefault(color, 0) + 1);

            result[i] = map.size();
        }

        return result;
    }

    public static void main(String args[]) {
        int limit = 4;
        int queries[][] = { { 0, 1 }, { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 } };

        int ans[] = distinctColors(limit, queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
