public class Remove_Maximum_and_Minimum_from_Arrays {

    public static int minDeletions(int nums[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = nums.length;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int option1 = Math.max(minIndex + 1, maxIndex + 1);
        int option2 = Math.max(nums.length - minIndex, nums.length - maxIndex);
        int option3 = Math.min((minIndex + 1) + (nums.length - maxIndex), (maxIndex + 1) + (nums.length - minIndex));

        return Math.min(option1, Math.min((option2), option3));
    }

    public static void main(String[] args) {
        int nums[] = { 2, 10, 7, 5, 4, 1, 8, 6 };

        System.out.println(minDeletions(nums));
    }
}
