public class find_index_of_element_array {
    public static int find_index(int numbers[], int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(find_index(numbers, target));
    }
}