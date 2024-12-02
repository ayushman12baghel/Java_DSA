import java.util.*;

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

    public static int isPrefixOfWord2(String str, String word) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                sb.append(ch);
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0) {
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            String currWord = list.get(i);

            if (currWord.length() >= word.length()) {
                boolean isMatch = true;

                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) != currWord.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        String sentence = "i love eating burger";
        String searchWord = "burg";

        System.out.println(isPrefixOfWord(sentence, searchWord));
        System.out.println(isPrefixOfWord2(sentence, searchWord));
    }
}
