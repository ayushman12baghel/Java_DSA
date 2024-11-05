public class Minimum_Number_of_changes_to_make_binary_string_beautiful {

    public static int minChanges(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i += 2) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "1001";

        System.out.println(minChanges(str));
    }
}
