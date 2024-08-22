public class String_Compression {

    public static int compress(char chars[]) {
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            chars[index++] = ch;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static void main(String args[]) {
        char chars[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();

        int length = compress(chars);
        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}
