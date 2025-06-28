import java.io.*;
import java.util.*;

public class Restaurant_Customers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arrival = new int[n];
        int[] leaving = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            arrival[i] = Integer.parseInt(parts[0]);
            leaving[i] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(arrival);
        Arrays.sort(leaving);

        int max = 0, curr = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arrival[i] < leaving[j]) {
                curr++;
                max = Math.max(max, curr);
                i++;
            } else {
                curr--;
                j++;
            }
        }

        System.out.println(max);
    }
}
