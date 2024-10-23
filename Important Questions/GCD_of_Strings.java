public class GCD_of_Strings {

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }

    public static String gcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        String str1 = "ABCABC", str2 = "ABC";

        System.out.println(gcdOfStrings(str1, str2));
        System.out.println(gcdOfStrings2(str1, str2));
    }
}
