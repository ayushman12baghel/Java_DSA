import java.util.*;

public class Good_Days_to_rob_a_Bank {

    public static List<Integer> goodDaysToRobBank(int security[], int time) {
        int n = security.length;
        int count = 0;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
            prefix[i] = count;
        }

        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            suffix[i] = count;
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] >= time && suffix[i] >= time) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String args[]) {
        int security[] = { 5, 3, 3, 3, 5, 6, 2 };
        int time = 2;

        List<Integer> list = goodDaysToRobBank(security, time);
        System.out.println(list);
    }
}
