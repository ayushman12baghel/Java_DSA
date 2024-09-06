import java.util.*;

public class Letter_Combination_of_phoneNumber {

    public static List<String> letterCombination(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, map, list, new StringBuilder(), 0);

        return list;
    }

    public static void backtrack(String digits, HashMap<Character, String> map, List<String> list, StringBuilder sb,
            int index) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (Character c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, map, list, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String args[]) {
        String str = "459";
        List<String> list = letterCombination(str);

        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
