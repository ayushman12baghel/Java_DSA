public class FInd_Numbers_with_Even_numbers_digits {

    // Approach 1
    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (isEven(num)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isEven(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count % 2 == 0;
    }

    // Approach 2
    public static int findNumbers2(int[] nums) {
        int count = 0;

        for (int num : nums) {
            String str = Integer.toString(num);
            if (str.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    // Apprach 3
    public static int findNumbers3(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || (num >= 100000 && num <= 999999)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 12, 345, 2, 6, 7896 };

        System.out.println(findNumbers(nums));
        System.out.println(findNumbers2(nums));
        System.out.println(findNumbers3(nums));
    }
}
