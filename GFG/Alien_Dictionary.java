import java.util.*;

//Approach Using Kahn Algorithm O(n*m)
class Solution {
    public String findOrder(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();

        for (char c : set) {
            graph.put(c, new ArrayList<>());
            indeg.put(c, 0);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int minLength = Math.min(s1.length(), s2.length());

            for (int j = 0; j < minLength; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    char c1 = s1.charAt(j);
                    char c2 = s2.charAt(j);

                    graph.get(c1).add(c2);
                    indeg.put(c2, indeg.get(c2) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : indeg.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            sb.append(current);

            for (char neighbour : graph.get(current)) {
                indeg.put(neighbour, indeg.get(neighbour) - 1);

                if (indeg.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (sb.length() != set.size()) {
            return "";
        }

        return sb.toString();
    }
}