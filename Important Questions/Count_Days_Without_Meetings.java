import java.util.Arrays;

public class Count_Days_Without_Meetings {

    // Tryed Using Difference Array Teachnique But M.L.E
    public static int countDays(int days, int[][] meetings) {
        int diff[] = new int[days + 1];
        for (int meeting[] : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            diff[start] += 1;
            if (end + 1 < diff.length) {
                diff[end + 1] += -1;
            }
        }

        int cumSum = 0;
        int freeDays = 0;

        for (int i = 1; i < diff.length; i++) {
            cumSum += diff[i];
            if (cumSum == 0) {
                freeDays++;
            }
        }

        return freeDays;
    }

    // Approach Using Sorting
    public static int countDays2(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int freeDays = 0;
        int prevEnd = 0;

        for (int meeting[] : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            freeDays += Math.max(start - prevEnd - 1, 0);
            prevEnd = Math.max(end, prevEnd);
        }

        freeDays += Math.max(0, days - prevEnd);

        return freeDays;
    }

    public static void main(String args[]) {
        int days = 10;
        int meetings[][] = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        System.out.println(countDays(days, meetings));
        System.out.println(countDays2(days, meetings));
    }
}
