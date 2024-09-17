public class MinimumNumberofSwapstoMaketheBinaryStringAlternating {

    public static int minSwaps(String str) {
        int one = 0, zero = 0, miss0 = 0, miss1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                one++;
            } else {
                zero++;
            }
        }
        if (Math.abs(zero - one) > 1) {
            return -1;
        }
        for (int i = 0; i < str.length(); i += 2) {
            if (str.charAt(i) == '1') {
                miss0++;
            } else {
                miss1++;
            }
        }

        return zero == one ? Math.min(miss0, miss1) : zero > one ? miss1 : miss0;
    }

    public static void main(String args[]) {
        String str = "111000";

        System.out.println(minSwaps(str));
    }
}
