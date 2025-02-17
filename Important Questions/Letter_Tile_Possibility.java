import java.util.*;

public class Letter_Tile_Possibility {

    // Approach 1
    public static int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean visited[] = new boolean[n];
        Set<String> set = new HashSet<>();

        solve(tiles, visited, set, "");

        return set.size() - 1;
    }

    public static void solve(String tiles, boolean visited[], Set<String> set, String current) {
        set.add(current);

        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            solve(tiles, visited, set, current + tiles.charAt(i));
            visited[i] = false;
        }
    }

    // Approach 2
    static int count;

    public static int numTilePossibilities2(String tiles) {
        int freq[] = new int[26];
        count = 0;
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        solve(freq);
        return count - 1;
    }

    public static void solve(int freq[]) {
        count++;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                solve(freq);
                freq[i]++;
            }
        }
    }

    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
        System.out.println(numTilePossibilities2(tiles));
    }
}