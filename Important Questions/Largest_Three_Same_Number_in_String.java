import java.util.HashMap;

public class Largest_Three_Same_Number_in_String {

    // Approach 1 Using Sliding Window
    public static String largestGoodInteger(String num) {
        int i = 0;
        int j = 0;
        char maxChar = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < num.length()) {
            map.put(num.charAt(j), map.getOrDefault(num.charAt(j), 0) + 1);

            while (j - i + 1 > 3) {
                map.put(num.charAt(i), map.get(num.charAt(i)) - 1);
                if (map.get(num.charAt(i)) == 0) {
                    map.remove(num.charAt(i));
                }
                i++;
            }

            if (map.get(num.charAt(j)) != null && map.get(num.charAt(j)) == 3) {
                if (num.charAt(j) > maxChar) {
                    maxChar = num.charAt(j);
                }
            }

            j++;
        }

        if (maxChar == 0) {
            return "";
        }

        return "" + maxChar + maxChar + maxChar;
    }

    // Approach 2 Simple Iteration
    public static String largestGoodInteger2(String num) {
        String maxGood = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String triple = num.substring(i, i + 3);

                if (maxGood.isEmpty() || triple.compareTo(maxGood) > 0) {
                    maxGood = triple;
                }
            }
        }

        return maxGood;
    }

    public static void main(String[] args) {
        String num = "6777133339";

        System.out.println(largestGoodInteger(num));
        System.out.println(largestGoodInteger2(num));
    }
}
