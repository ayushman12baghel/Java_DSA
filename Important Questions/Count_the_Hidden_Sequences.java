public class Count_the_Hidden_Sequences {

    // Brute Force (n^2)
    public static int numberOfArrays(int differences[], int lower, int upper) {
        int count = 0;

        for (int i = lower; i <= upper; i++) {
            boolean canTake = true;
            int sum = i;
            for (int j = 0; j < differences.length; j++) {
                sum += differences[j];
                if (sum > upper || sum < lower) {
                    canTake = false;
                    break;
                }
            }

            if (canTake) {
                count++;
            }
        }

        return count;
    }

    // Approach 2 Applying some maths O(n)
    public static int numberOfArrays2(int[] differences, int lower, int upper) {
        int maxDifference = 0;
        int minDifference = 0;
        int sum = 0;

        for (int i = 0; i < differences.length; i++) {
            sum += differences[i];
            maxDifference = Math.max(sum, maxDifference);
            minDifference = Math.min(sum, minDifference);

            if ((upper - lower) < (maxDifference - minDifference))
                return 0;

        }

        int l = lower - minDifference;
        int u = upper - maxDifference;

        return ((u - l + 1 >= 0) ? (u - l + 1) : 0);
    }

    public static void main(String args[]) {
        int differences[] = { 1, -3, 4 };
        int lower = 1;
        int upper = 6;

        System.out.println(numberOfArrays(differences, lower, upper));
        System.out.println(numberOfArrays2(differences, lower, upper));
    }
}
