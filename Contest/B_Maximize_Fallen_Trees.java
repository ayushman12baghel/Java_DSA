package Contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_Maximize_Fallen_Trees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int count = 1;
        int lastPos = x[0];

        for (int i = 1; i < n - 1; i++) {
            if (x[i] - h[i] > lastPos) {
                count++;
                lastPos = x[i];
            } else if (x[i] + h[i] < x[i + 1]) {
                count++;
                lastPos = x[i] + h[i];
            } else {
                lastPos = x[i];
            }
        }

        count++;

        System.out.println(count);
    }
}
