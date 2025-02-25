public class Number_of_Subarrays_with_Odd_SUm {

    public static int numOfSubarrays(int nums[]) {
        int even = 1;
        int odd = 0;
        int count = 0;
        int sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum % 2 == 0) {
                count += odd;
                even++;
            } else {
                count += even;
                odd++;
            }

            count %= mod;
        }

        return count;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5 };
        System.out.println(numOfSubarrays(arr));
    }
}
