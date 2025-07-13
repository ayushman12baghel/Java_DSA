import java.util.*;

public class Assign_Cookies {

    public static int findContentChildren(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n && j < m) {
            if (players[i] > trainers[j]) {
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int g[] = { 1, 2, 3 }, s[] = { 1, 1 };

        System.out.println(findContentChildren(g, s));
    }
}
