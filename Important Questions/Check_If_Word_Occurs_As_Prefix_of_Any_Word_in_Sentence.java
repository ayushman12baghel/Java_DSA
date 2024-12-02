public class Check_If_Word_Occurs_As_Prefix_of_Any_Word_in_Sentence {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int ch = 0;
        int currWord = 1;

        for (int i = 0; i < sentence.length(); i++) {
            if (ch != -1 && sentence.charAt(i) == searchWord.charAt(ch)) {
                ch++;
            } else if (sentence.charAt(i) == ' ') {
                ch = 0;
                currWord++;
            } else {
                ch = -1;
            }

            if (searchWord.length() == ch) {
                return currWord;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        String sentence = "i love eating burger";
        String searchWord = "burg";

        System.out.println(isPrefixOfWord(sentence, searchWord));
    }
}
