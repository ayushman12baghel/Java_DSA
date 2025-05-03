import java.util.*;

public class Push_Dominoes {

    // Approach 1: (O(n) time : Finding closest 'L' and closest 'R')
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int rightClosestL[] = new int[n];
        int leftClosestR[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                leftClosestR[i] = i;
            } else if (dominoes.charAt(i) == '.') {
                leftClosestR[i] = i > 0 ? leftClosestR[i - 1] : -1;
            } else {
                leftClosestR[i] = -1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                rightClosestL[i] = i;
            } else if (dominoes.charAt(i) == '.') {
                rightClosestL[i] = i < n - 1 ? rightClosestL[i + 1] : -1;
            } else {
                rightClosestL[i] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int distLeftR = Math.abs(i - leftClosestR[i]);
            int distRightL = Math.abs(i - rightClosestL[i]);

            if (rightClosestL[i] == leftClosestR[i]) {
                sb.append('.');
            } else if (leftClosestR[i] == -1) {
                sb.append('L');
            } else if (rightClosestL[i] == -1) {
                sb.append('R');
            } else if (distLeftR == distRightL) {
                sb.append('.');
            } else {
                sb.append(distRightL > distLeftR ? 'R' : 'L');
            }
        }

        return sb.toString();
    }

    // Approach 2: (O(n) time : Using Force Simulation)
    public static String pushDominoes2(String dominoes) {
        int n = dominoes.length();
        int forces[] = new int[n];

        // Move from left to right and look for right force 'R'
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }

            forces[i] = force;
        }

        // Move from right to left and look for left force 'L'
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }

            forces[i] -= force;
        }

        // Now I will find resultant direction on each domino basis of resultant force
        // on them
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (forces[i] > 0) {
                sb.append('R');
            } else if (forces[i] < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String dominoes = ".L.R...LR..L..";

        System.out.println(pushDominoes(dominoes));
        System.out.println(pushDominoes2(dominoes));
    }
}
