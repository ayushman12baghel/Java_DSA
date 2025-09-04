import java.util.*;

public class Find_Closest_Person {

    // By Maths
    public static int findClosest(int x, int y, int z) {
        int diffFrom1 = Math.abs(x - z);
        int diffFrom2 = Math.abs(y - z);

        if (diffFrom1 == diffFrom2) {
            return 0;
        }

        return diffFrom1 > diffFrom2 ? 2 : 1;
    }

    public static void main(String[] args) {
        int x = 2, y = 7, z = 4;

        System.out.println(findClosest(x, y, z));
    }
}