public class remove_duplicates_from_string {
    public static void remove_duplicates(String str, int index, StringBuilder newstr, boolean map[]) {
        if (index == str.length()) {
            System.out.println(newstr);
            return;
        }
        // kaam
        char currChar = str.charAt(index);
        if (map[currChar - 'a'] == true) {
            // duplicate
            remove_duplicates(str, index + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            newstr.append(currChar);
            remove_duplicates(str, index + 1, newstr, map);
        }
    }

    public static void main(String[] args) {
        String str = "appnnacollege";
        remove_duplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
