public class Sort_Array_By_Parity {

    public static int[] sortArrayByParity(int nums[]) {
        int arr[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                arr[left++] = nums[i];
            } else {
                arr[right--] = nums[i];
            }
        }

        return arr;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 1, 2, 4 };
        int arr[] = sortArrayByParity(nums);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
