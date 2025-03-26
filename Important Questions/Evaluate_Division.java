import java.util.*;

public class Evaluate_Division {

    public static double[] calcEquation(List<List<String>> equations, double values[], List<List<String>> queries) {
        int n = equations.size();
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, value);
            graph.get(v).put(u, 1.0 / value);
        }

        double result[] = new double[queries.size()];
        int i = 0;

        for (List<String> query : queries) {
            String src = query.get(0);
            String dest = query.get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i++] = -1.0;
            } else if (src.equals(dest)) {
                result[i++] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i++] = dfs(graph, src, dest, visited);
            }
        }

        return result;
    }

    public static double dfs(Map<String, Map<String, Double>> graph, String src, String dest, Set<String> visited) {
        if (visited.contains(src)) {
            return -1.0;
        }
        if (src.equals(dest)) {
            return 1.0;
        }

        visited.add(src);

        for (Map.Entry<String, Double> neighbour : graph.get(src).entrySet()) {
            double result = dfs(graph, neighbour.getKey(), dest, visited);

            if (result != -1) {
                return result * neighbour.getValue();
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x"));

        double result[] = calcEquation(equations, values, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
