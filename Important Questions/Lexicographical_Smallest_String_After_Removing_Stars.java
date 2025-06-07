import java.util.*;

public class Lexicographical_Smallest_String_After_Removing_Stars {

    static class Pair {
        char ch;
        int index;

        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public static String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.ch != b.ch) ? a.ch - b.ch : b.index - a.index);
        char str[] = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char c = str[i];

            if (c != '*') {
                pq.offer(new Pair(c, i));
                continue;
            }

            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                str[p.index] = '*';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '*') {
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "aaba*";

        System.out.println(clearStars(str));
    }
}
