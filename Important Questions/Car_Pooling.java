public class Car_Pooling {

    public static boolean carPooling(int trips[][], int capacity) {
        int m[] = new int[1001];
        for (int trip[] : trips) {
            m[trip[1]] += trip[0];
            m[trip[2]] -= trip[0];
        }

        for (int i = 0; i < 1001 && capacity >= 0; i++) {
            capacity -= m[i];
        }

        return capacity >= 0;
    }

    public static void main(String args[]) {
        int trips[][] = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 5;

        System.out.println(carPooling(trips, capacity));
    }
}
