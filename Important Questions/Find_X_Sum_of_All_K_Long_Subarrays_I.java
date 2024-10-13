import java.util.*;

public class Find_X_Sum_of_All_K_Long_Subarrays_I {

    public static int[] findXSum(int nums[], int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            int subarray[] = Arrays.copyOfRange(nums, i, i + k);
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : subarray) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<HashMap.Entry<Integer, Integer>> freqList = new ArrayList<>(map.entrySet());

            freqList.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                } else {
                    return b.getKey() - a.getKey();
                }
            });

            int xSum = 0;
            int count = 0;

            for (HashMap.Entry<Integer, Integer> entry : freqList) {
                if (count < x) {
                    xSum += entry.getKey() * entry.getValue();
                    count++;
                } else {
                    break;
                }
            }

            result.add(xSum);
        }

        int ans[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 8, 7, 8, 7, 5 };
        int k = 2;
        int x = 2;

        int ans[] = findXSum(nums, k, x);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
