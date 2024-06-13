import java.util.Arrays;

public class MinNumberOfMovesToSeatEveryone {

    public static int minMovesToSeat(int seats[], int students[]) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }

    public static void main(String args[]) {
        int seats[] = { 4, 1, 5, 9 };
        int students[] = { 1, 3, 2, 6 };
        System.out.println(minMovesToSeat(seats, students));
    }
}
