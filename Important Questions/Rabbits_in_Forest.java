import java.util.*;

public class Rabbits_in_Forest {

    // Using HashMap groupSize of rabbits=they say +1(to count them also)
    public static int numRabbits(int answers[]) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();
            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) count / groupSize);

            ans += (groups * groupSize);
        }

        return ans;
    }

    public static void main(String args[]) {
        int answers[] = { 10, 10, 10 };

        System.out.println(numRabbits(answers));
    }
}
