public class selection_sort {
    public static void selection_sort(int numbers[]) {
        for (int i = 1; i < numbers.length; i++) {
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[min] < numbers[j]) {
                    min = j;
                }
            }
            int temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
        for (int i = 1; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        int numbers[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        selection_sort(numbers);
    }
}
