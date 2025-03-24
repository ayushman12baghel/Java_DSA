import java.util.*;

public class Reorganise_String {

    // Approach 1 Using PriorityQueue
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
        int prevChar[] = pq.poll();
        sb.append((char) prevChar[0]);
        prevChar[1]--;
        while (!pq.isEmpty()) {
            int currentChar[] = pq.poll();
            sb.append((char) currentChar[0]);
            currentChar[1]--;
            if (prevChar[1] > 0) {
                pq.offer(prevChar);
            }
            prevChar = currentChar;
        }

        return sb.toString();
    }

    // Approach 2 By Putting MaxFreq Character first alternatively
    public static String reorganizeString2(String str) {
        int length = str.length();
        char ans[] = new char[length];
        int freq[] = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        char maxFreqChar = '#';

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq) {
                maxFreq = freq[c - 'a'];
                maxFreqChar = c;
            }
            if (freq[c - 'a'] > (str.length() + 1) / 2) {
                return "";
            }
        }

        int i = 0;
        while (maxFreq > 0) {
            ans[i] = maxFreqChar;
            i += 2;
            maxFreq--;
            freq[maxFreqChar - 'a']--;
        }

        for (int j = 0; j < 26; j++) {
            while (freq[j] > 0) {
                if (i > length - 1) {
                    i = 1;
                }
                ans[i] = (char) ('a' + j);
                freq[j]--;
                i += 2;
            }
        }

        return new String(ans);
    }

    public static void main(String args[]) {
        String str = "aab";

        System.out.println(reorganizeString(str));
        System.out.println(reorganizeString2(str));
    }
}
