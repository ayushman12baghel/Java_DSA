public class Shifting_Letters_II {

    public static String shiftingLetters(String str, int shifts[][]) {
        int n = str.length();
        int diff[] = new int[n];

        for (int shift[] : shifts) {
            int left = shift[0];
            int right = shift[1];
            int direction = shift[2];
            int x;
            if (direction == 0) {
                x = -1;
            } else {
                x = 1;
            }
            diff[left] += x;
            if (right + 1 < n) {
                diff[right + 1] -= x;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26;

            if (shift < 0) {
                shift += 26;
            }

            sb.setCharAt(i, (char) ((((str.charAt(i) - 'a') + shift) % 26) + 'a'));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "abc";
        int shifts[][] = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };

        System.out.println(shiftingLetters(str, shifts));
    }
}
