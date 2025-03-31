import java.util.*;

public class Partition_Labels {

    public static List<Integer> partitionLabels(String str) {
        List<Integer> ans = new ArrayList<>();
        int lastIndex[] = new int[26];

        for (int i = 0; i < st r.length(); i++) {
            lastIndex[str.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < str.length()) {
            int end = lastIndex[str.charAt(i) - 'a'];
            int j = i;

            while (j < end) {
                end = Math.max(end, lastIndex[str.charAt(j) - 'a']);
                j++;
            }

            ans.add(j - i + 1);
            i = j + 1;
        }

        return ans;
    }

    public static void main(String args[]) {
        String str = "ababcbacadefegdehijhklij";

        System.out.println(partitionLabels(str));
    }
}
