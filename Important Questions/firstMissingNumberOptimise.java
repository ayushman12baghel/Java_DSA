public class firstMissingNumberOptimise {
    public static void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int FirstMissingPositive(int nums[]) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] != nums[correctIndex] && nums[i] <= n) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, -1, 1 };
        System.out.println(FirstMissingPositive(nums));
    }
}
