public class number_to_string {
    public static void numberToString(int num) {
        String arr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        if (num == 0) {
            return;
        }
        int lastDigit = num % 10;
        num /= 10;
        numberToString(num);
        System.out.print(arr[lastDigit] + " ");
    }

    public static void main(String[] args) {
        int num = 20198;
        numberToString(num);
    }
}
