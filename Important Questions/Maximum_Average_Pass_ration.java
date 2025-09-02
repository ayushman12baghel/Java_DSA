import java.util.*;

//Brute Force Approach O(n^2)
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        double passRatio[] = new double[n];
        for (int i = 0; i < n; i++) {
            passRatio[i] = (double) classes[i][0] / classes[i][1];
        }

        while (extraStudents-- > 0) {
            double temp[] = new double[n];

            for (int i = 0; i < n; i++) {
                temp[i] = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            }

            int bestClassIndex = 0;
            double bestClassValue = 0;

            for (int i = 0; i < n; i++) {
                double value = temp[i] - passRatio[i];

                if (value > bestClassValue) {
                    bestClassIndex = i;
                    bestClassValue = value;
                }
            }

            passRatio[bestClassIndex] = (double) (classes[bestClassIndex][0] + 1) / (classes[bestClassIndex][1] + 1);
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;
        }

        double ans = 0;

        for (int i = 0; i < n; i++) {
            ans += passRatio[i];
        }

        return ans / n;
    }
}

// Approach 2 Using PriorityQueue O(nlogk)
class Solution {

    class Pair {
        double ratio;
        int index;

        public Pair(double ratio, int index) {
            this.ratio = ratio;
            this.index = index;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.ratio, a.ratio));
        for (int i = 0; i < n; i++) {
            double current = (double) (classes[i][0]) / (classes[i][1]);
            double updated = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double diff = updated - current;
            pq.offer(new Pair(diff, i));
        }

        while (extraStudents-- > 0) {
            Pair curr = pq.poll();
            int index = curr.index;

            classes[index][0]++;
            classes[index][1]++;

            double current = (double) (classes[index][0]) / (classes[index][1]);
            double updated = (double) (classes[index][0] + 1) / (classes[index][1] + 1);
            double diff = updated - current;
            pq.offer(new Pair(diff, index));
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (double) (classes[i][0]) / (classes[i][1]);
        }

        return ans / n;
    }
}