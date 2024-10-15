public class Separate_Black_and_White_Balls {

    public static long minimumSteps(String s) {
        int count = 0;
        long steps = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else if (s.charAt(i) == '0') {
                steps += count;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        String s = "100";
        System.out.println(minimumSteps(s));
    }
}
