import java.util.*;

public class Chocola_Problem {
    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer verCost[] = { 2, 1, 3, 1, 4 };
        Integer horCost[] = { 4, 1, 2 };

        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horCost, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < horCost.length && v < verCost.length) {
            // vertical cost< horizontal cost
            if (verCost[v] <= horCost[h]) { // horizontal cut
                cost += (horCost[h] * vp);
                hp++;
                h++;
            } else {// vertical cut
                cost += (verCost[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < horCost.length) {
            cost += (horCost[h] * vp);
            hp++;
            h++;
        }

        while (v < verCost.length) {
            cost += (verCost[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost of cuts: " + cost);
    }
}
