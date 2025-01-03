public class Maximum_Score_After_Splitting_a_String {

    public static int maxScore(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    curr++;
                }
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    curr++;
                }
            }
            result = Math.max(curr, result);
        }

        return result;
    }

    public static int maxScore2(String s) {
        int ans = 0;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int zeros = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ones + zeros, ans);
        }

        return ans;
    }

    public static int maxScore3(String s) {
        int ans = Integer.MIN_VALUE;
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }

            ans = Math.max(zeros - ones, ans);
        }
        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }

        return ans + ones;
    }

    public static void main(String args[]) {
        String str = "011101";
        System.out.println(maxScore2(str));
        System.out.println(maxScore(str));
        System.out.println(maxScore3(str));
    }
}
