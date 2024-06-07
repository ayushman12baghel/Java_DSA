import java.util.*;

public class Max_Length_of_Pairs {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 } };
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chailLen = 1;
        int chainEnd = pairs[0][1]; // Last selected pair end //chain end
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chailLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Maximum length of chain: " + chailLen);
    }
}
