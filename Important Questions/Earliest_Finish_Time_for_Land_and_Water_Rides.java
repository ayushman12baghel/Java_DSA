public class Earliest_Finish_Time_for_Land_and_Water_Rides {

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
            int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landFirst = landStartTime[i];
                int landEnd = landDuration[i] + landFirst;
                int waterSecond = Math.max(waterStartTime[j], landEnd);
                int waterEnd = waterSecond + waterDuration[j];
                minTime = Math.min(minTime, waterEnd);

                int waterFirst = waterStartTime[j];
                waterEnd = waterDuration[j] + waterFirst;
                int landSecond = Math.max(landStartTime[i], waterEnd);
                landEnd = landSecond + landDuration[i];
                minTime = Math.min(minTime, landEnd);
            }
        }

        return minTime;
    }

    public static void main(String[] args) {
        int landStartTime[] = { 2, 8 }, landDuration = { 4, 1 }, waterStartTime = { 6 }, waterDuration = { 3 };
    }
}
