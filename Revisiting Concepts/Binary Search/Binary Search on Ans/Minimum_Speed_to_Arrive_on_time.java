public class Minimum_Speed_to_Arrive_on_time {

    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(dist, hour, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int[] dist, double hour, int speed) {
        double totalTime = 0.0;

        for (int i = 0; i < dist.length - 1; i++) {
            int timeForSegment = (dist[i] + speed - 1) / speed; // Math.ceil(dist[i]/speed)
            totalTime += timeForSegment;
        }

        totalTime += (double) dist[dist.length - 1] / speed;

        return totalTime <= hour;
    }

    public static void main(String[] args) {
        int dist[] = { 1, 3, 2 };
        double hour = 2.7;

        System.out.println(minSpeedOnTime(dist, hour));
    }
}
