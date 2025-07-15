import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Secret_Passwords {
    static class DSU {
        int parent[];
        int size[];

        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            if (size[parentX] > size[parentY]) {
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            } else if (size[parentX] < size[parentY]) {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            } else {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[] passwords = new String[n];

        for (int i = 0; i < n; i++) {
            passwords[i] = reader.readLine();
        }

        DSU dsu = new DSU(26);

        boolean letterUsed[] = new boolean[26];

        for (String password : passwords) {
            char letters[] = password.toCharArray();
            int firstLetter = letters[0] - 'a';
            letterUsed[firstLetter] = true;

            for (int i = 1; i < letters.length; i++) {
                int current = letters[i] - 'a';
                letterUsed[current] = true;
                dsu.union(firstLetter, current);
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (letterUsed[i] && dsu.find(i) == i) {
                count++;
            }
        }

        System.out.println(count);
    }
}
