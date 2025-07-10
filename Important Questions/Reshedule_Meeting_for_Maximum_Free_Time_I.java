import java.util.*;

public class Reshedule_Meeting_for_Maximum_Free_Time_I {

    // Using SLiding Window
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> freeArray = new ArrayList<>();

        freeArray.add(startTime[0]);

        for (int i = 1; i < startTime.length; i++) {
            freeArray.add(startTime[i] - endTime[i - 1]);
        }

        freeArray.add(eventTime - endTime[startTime.length - 1]);

        int i = 0;
        int j = 0;
        int maxSum = 0;
        int currSum = 0;

        while (j < freeArray.size()) {
            currSum += freeArray.get(j);

            while (j - i + 1 > k + 1) {
                currSum -= freeArray.get(i);
                i++;
            }

            maxSum = Math.max(maxSum, currSum);
            j++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int eventTime = 5, k = 1, startTime[] = { 1, 3 }, endTime[] = { 2, 5 };

        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
}
