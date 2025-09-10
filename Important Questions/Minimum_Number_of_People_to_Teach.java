import java.util.*;

//Greedy Approach O(freindShip*language + n*language)
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUser = new HashSet<>();
        for (int friendship[] : friendships) {
            Set<Integer> user1 = new HashSet<>();
            for (int num : languages[friendship[0] - 1]) {
                user1.add(num);
            }

            boolean found = false;
            for (int num : languages[friendship[1] - 1]) {
                if (user1.contains(num)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                sadUser.add(friendship[0]);
                sadUser.add(friendship[1]);
            }
        }

        HashMap<Integer, Integer> mostTalkedLanguage = new HashMap<>();

        for (int num : sadUser) {
            for (int language : languages[num - 1]) {
                mostTalkedLanguage.put(language, mostTalkedLanguage.getOrDefault(language, 0) + 1);
            }
        }

        int mostTalkedLanguageAmongSadUser = 0;

        for (int value : mostTalkedLanguage.values()) {
            mostTalkedLanguageAmongSadUser = Math.max(mostTalkedLanguageAmongSadUser, value);
        }

        return sadUser.size() - mostTalkedLanguageAmongSadUser;
    }
}