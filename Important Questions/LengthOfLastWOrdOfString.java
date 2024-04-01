public interface LengthOfLastWOrdOfString {
    public static int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        int count = 0;
        for (int i = n; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0) {
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String s = "   fly me   to   the moon  ";// output =4;
        System.out.println(lengthOfLastWord(s));
    }
}
