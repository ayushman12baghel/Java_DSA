import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        long absNumerator = Math.abs((long) numerator);
        long absDenominator = Math.abs((long) denominator);
        if ((long) numerator * denominator < 0) {
            sb.append('-');
        }

        long intValue = absNumerator / absDenominator;
        sb.append(intValue);

        long remain = (long) absNumerator % absDenominator;
        if (remain == 0) {
            return sb.toString();
        }

        sb.append('.');

        HashMap<Long, Integer> map = new HashMap<>();

        while (remain != 0) {
            if (map.containsKey(remain)) {
                int insertPos = map.get(remain);
                sb.insert(insertPos, '(');
                sb.append(')');
                break;
            }

            map.put(remain, sb.length());
            remain *= 10;
            long digit = remain / absDenominator;
            sb.append(digit);
            remain %= denominator;
        }

        return sb.toString();
    }
}