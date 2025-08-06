public class Roman_Number_to_Integer {

    public static int romanToDecimal(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = findValue(s.charAt(i));

            if (i + 1 < s.length()) {
                int value2 = findValue(s.charAt(i + 1));

                if (value2 > value) {
                    ans += (value2 - value);
                    i++;
                } else {
                    ans += value;
                }
            } else {
                ans += value;
            }
        }

        return ans;
    }

    public static int findValue(char c) {
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;
        return -1;
    }

    public static void main(String[] args) {
        String s = "IX";

        System.out.println(romanToDecimal(s));
    }
}
