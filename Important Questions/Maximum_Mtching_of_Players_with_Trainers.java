import java.util.*;

public class Maximum_Mtching_of_Players_with_Trainers {

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
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
        int playters[] = { 4, 7, 9 };
        int trainers[] = { 8, 2, 5, 8 };

        System.out.println(matchPlayersAndTrainers(playters, trainers));
    }
}
