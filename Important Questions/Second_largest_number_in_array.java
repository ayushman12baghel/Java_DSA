public class Second_largest_number_in_array {
    public static void main(String[] args) {
        int arr[] = { -1, -25, -75, -89, -35, -10, -55, -87 };

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("The second largest is: " + second);
    }
}
