public class Plus_One {

    public static int[] plusOne(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String args[]) {
        int arr[] = { 9, 9, 9, 9 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int x[] = plusOne(arr);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
