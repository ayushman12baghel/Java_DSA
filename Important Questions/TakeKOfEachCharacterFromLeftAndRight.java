public class TakeKOfEachCharacterFromLeftAndRight {

    public static int takeCharacters(String str, int k) {
        int count_a = 0;
        int count_b = 0;
        int count_c = 0;
        int notDeleted = 0;

        for (char c : str.toCharArray()) {
            if (c == 'a') {
                count_a++;
            } else if (c == 'b') {
                count_b++;
            } else {
                count_c++;
            }
        }

        if (count_a < k || count_b < k || count_c < k) {
            return -1;
        }

        int i = 0;
        int j = 0;

        while (j < str.length()) {
            if (str.charAt(j) == 'a') {
                count_a--;
            } else if (str.charAt(j) == 'b') {
                count_b--;
            } else {
                count_c--;
            }

            while (i <= j && (count_a < k || count_b < k || count_c < k)) {
                if (str.charAt(i) == 'a') {
                    count_a++;
                } else if (str.charAt(i) == 'b') {
                    count_b++;
                } else {
                    count_c++;
                }

                i++;
            }

            notDeleted = Math.max(notDeleted, j - i + 1);
            j++;
        }

        return str.length() - notDeleted;
    }

    public static void main(String args[]) {
        String str = "aabaaaacaabc";
        int k = 2;

        System.out.println(takeCharacters(str, k));
    }
}
