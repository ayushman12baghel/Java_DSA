public class Minimum_Recolors_to_get_K_consecutive_Black_Colors {

    // Brute Force Approach T.C O(n*k)
    public static int minimumRecolors(String blocks, int k) {
        int minCount = Integer.MAX_VALUE;
        int n = blocks.length();

        for (int i = 0; i <= n - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    count++;
                }
            }
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    // Sliding Window Approach T.C O(n)
    public static int minimumRecolors2(String blocks, int k) {
        int white = 0;
        int n = blocks.length();

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }
        int minChange = white;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                white--;
            }
            if (blocks.charAt(i) == 'W') {
                white++;
            }

            minChange = Math.min(minChange, white);
        }

        return minChange;
    }

    public static void main(String args[]) {
        String blocks = "WBBWWBBWBW";
        int k = 7;

        System.out.println(minimumRecolors(blocks, k));
        System.out.println(minimumRecolors2(blocks, k));
    }
}
