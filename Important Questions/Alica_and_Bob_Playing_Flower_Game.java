public class Alica_and_Bob_Playing_Flower_Game {

    public static long flowerGame(int n, int m) {
        return (((n + 1) / 2 * (m / 2L)) + ((m + 1) / 2 * (n / 2L)));
    }

    public static void main(String[] args) {
        int n = 3, m = 2;

        System.out.println(flowerGame(n, m));
    }
}
