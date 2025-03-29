import java.util.*;

public class Task_Schedular {

    public static int leastInterval(char tasks[], int n) {
        int freq[] = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    int current = pq.poll();
                    current--;
                    list.add(current);
                }
            }

            for (int num : list) {
                if (num > 0) {
                    pq.offer(num);
                }
            }

            if (pq.isEmpty()) {
                time += list.size();
            } else {
                time += n + 1;
            }
        }

        return time;
    }

    public static void main(String args[]) {
        char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }
}
