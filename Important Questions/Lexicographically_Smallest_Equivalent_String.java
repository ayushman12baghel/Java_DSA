import java.util.*;
import java.util.LinkedList;

public class Lexicographically_Smallest_Equivalent_String {

    // Approach 1 Using BFS O(m)
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Character>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            graph.get(c1 - 'a').add(c2);
            graph.get(c2 - 'a').add(c1);
        }

        StringBuilder ans = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            ans.append(bfs(graph, c));
        }

        return ans.toString();
    }

    public static char bfs(List<List<Character>> graph, char c) {
        Queue<Character> queue = new LinkedList<>();
        boolean visited[] = new boolean[26];
        queue.offer(c);
        visited[c - 'a'] = true;

        char ans = c;

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (current < ans) {
                ans = current;
            }

            for (char neighbour : graph.get(current - 'a')) {
                if (!visited[neighbour - 'a']) {
                    queue.offer(neighbour);
                    visited[neighbour - 'a'] = true;
                }
            }
        }

        return ans;
    }

    // Approach 2 Using DSU
    static class DSU {
        int parent[];

        public DSU(int n) {
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            if (parentX < parentY) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
            }
        }
    }

    public static String smallestEquivalentString2(String s1, String s2, String baseStr) {
        DSU dsu = new DSU(26);

        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';

            dsu.union(c1, c2);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            int temp = dsu.find(baseStr.charAt(i) - 'a');
            sb.append((char) (temp + 'a'));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";

        System.out.println(smallestEquivalentString(s1, s2, baseStr));
        System.out.println(smallestEquivalentString2(s1, s2, baseStr));
    }
}
