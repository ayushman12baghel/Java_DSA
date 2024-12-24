import java.util.*;
import java.util.LinkedList;

public class Reveal_Cards_In_Increasing_Order {

    public static int[] deckRevealedIncreasing(int deck[]) {
        int n = deck.length;
        int ans[] = new int[n];
        Arrays.sort(deck);
        boolean skip = false;
        int i = 0;
        int j = 0;

        while (i < n) {
            if (ans[j] == 0) {
                if (!skip) {
                    ans[j] = deck[i++];
                }
                skip = !skip;
            }
            j = (j + 1) % n;
        }

        return ans;
    }

    public static int[] deckRevealedIncreasing2(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        Arrays.sort(deck);
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            ans[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }

        return ans;
    }

    public static void main(String args[]) {
        int deck[] = { 17, 13, 11, 2, 3, 5, 7 };

        int ans[] = deckRevealedIncreasing(deck);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        ans = deckRevealedIncreasing2(deck);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
