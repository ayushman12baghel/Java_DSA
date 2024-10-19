import java.util.*;

public class Reorganise_String {

    public static String reorganizeString(String s) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > (s.length() + 1) / 2) {
                    return "";
                }
                pq.offer(new int[] { i + 'a', freq[i] });
            }
        }
        StringBuilder sb = new StringBuilder();
        int block[] = pq.poll();
        sb.append((char) block[0]);
        block[1]--;
        while (!pq.isEmpty()) {
            int next[] = pq.poll();
            sb.append((char) next[0]);
            next[1]--;
            if (block[1] > 0) {
                pq.offer(block);
            }
            block = next;
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "aab";

        System.out.println(reorganizeString(str));
    }
}
