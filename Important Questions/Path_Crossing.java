import java.util.*;

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }
}

public class Path_Crossing {

    public static boolean pathCrossing(String str) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        int x = 0;
        int y = 0;

        set.add(new Pair(0, 0));

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            }
            if (str.charAt(i) == 'S') {
                y--;
            }
            if (str.charAt(i) == 'E') {
                x++;
            }
            if (str.charAt(i) == 'W') {
                x--;
            }

            Pair<Integer, Integer> pair = new Pair(x, y);

            if (set.contains(pair)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String str = "NESWW";
        System.out.println(pathCrossing(str));
    }
}
