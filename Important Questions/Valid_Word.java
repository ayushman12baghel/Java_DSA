public class Valid_Word {
    public static boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonent = false;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonent = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return hasVowel && hasConsonent;
    }

    public static void main(String[] args) {
        String word = "234Adas";

        System.out.println(isValid(word));
    }
}
