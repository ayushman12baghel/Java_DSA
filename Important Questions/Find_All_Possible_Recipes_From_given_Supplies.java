import java.util.*;
import java.util.LinkedList;

public class Find_All_Possible_Recipes_From_given_Supplies {

    // Brute Force O(n^2*m)
    public static List<String> findAllRecipes(String recipes[], String ingredients[][], String supplies[]) {
        Set<String> set = new HashSet<>();
        boolean found[] = new boolean[recipes.length];
        List<String> ans = new ArrayList<>();
        int count = recipes.length;

        for (String supply : supplies) {
            set.add(supply);
        }

        while (count-- > 0) {
            for (int i = 0; i < recipes.length; i++) {
                if (found[i]) {
                    continue;
                }

                boolean isPossible = true;
                for (String ingredient : ingredients[i]) {
                    if (!set.contains(ingredient)) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    found[i] = true;
                    set.add(recipes[i]);
                    ans.add(recipes[i]);
                }
            }
        }

        return ans;
    }

    // Approach 2 Using Topological Sort O(n+m+q)
    public static List<String> findAllRecipes2(String recipes[], String ingredients[][], String supplies[]) {
        int n = recipes.length;
        Set<String> set = new HashSet<>();
        Map<String, List<Integer>> map = new HashMap<>();
        int indeg[] = new int[n];
        List<String> ans = new ArrayList<>();

        for (String supply : supplies) {
            set.add(supply);
        }

        for (int i = 0; i < n; i++) {
            for (String ingredient : ingredients[i]) {
                if (!set.contains(ingredient)) {
                    map.putIfAbsent(ingredient, new ArrayList<>());
                    map.get(ingredient).add(i);
                    indeg[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            ans.add(recipes[temp]);

            if (map.containsKey(recipes[temp])) {
                for (int index : map.get(recipes[temp])) {
                    indeg[index]--;
                    if (indeg[index] == 0) {
                        queue.offer(index);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        String recipes[] = { "bread", "sandwich" };
        String ingredients[][] = { { "yeast", "flour" }, { "bread", "meat" } };
        String supplies[] = { "yeast", "flour", "meat" };
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
        System.out.println(findAllRecipes2(recipes, ingredients, supplies));
    }
}
