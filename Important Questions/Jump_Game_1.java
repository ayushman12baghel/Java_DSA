public class Jump_Game_1 {

    public static boolean canJump1(int arr[]) {
        int goal = arr.length - 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static boolean canJump2(int arr[]) {
        int reach = 0;

        for (int i = 0; i < arr.length; i++) {
            if (reach < i) {
                return false;
            }
            if (reach >= arr.length - 1) {
                return true;
            }
            reach = Math.max(reach, arr[i] + i);
        }

        return false;
    }

    public static boolean canJump3(int arr[]) {
        boolean dp[] = new boolean[arr.length];
        dp[0] = true;

        for (int i = 1; i < arr.length; i++) {
            int steps = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[arr.length - 1];
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 4 };

        System.out.println(canJump1(arr));
        System.out.println(canJump2(arr));
        System.out.println(canJump3(arr));
    }
}
