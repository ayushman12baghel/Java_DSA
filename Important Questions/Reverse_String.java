public class Reverse_String {

    public static void reverse(char str[]) {
        int left = 0;
        int right = str.length - 1;
        while (left < str.length / 2) {
            char curr = str[left];
            str[left] = str[right];
            str[right] = curr;
            left++;
            right--;
        }
    }

    public static void main(String args[]) {
        char[] str = { 'a', 'y', 'u', 's', 'h' };
        reverse(str);

        System.out.println(str);
    }
}
