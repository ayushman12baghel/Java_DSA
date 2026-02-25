import java.util.*;

//O(nlogn)
class Solution {
    class Pair {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] sortByBits(int[] nums) {
        List<Pair> numToBinary = new ArrayList<>();

        for (int num : nums) {
            numToBinary.add(new Pair(num, count(num)));
        }

        Collections.sort(numToBinary, (a, b) -> a.count == b.count ? a.num - b.num : a.count - b.count);

        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = numToBinary.get(i).num;
        }

        return ans;
    }

    public int count(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }
}

// Approach 2 O(nlogn)
class Solution {
    public int[] sortByBits(int[] nums) {
        Integer arr[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int countA = count(a);
            int countB = count(b);

            return countA == countB ? a - b : countA - countB;
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }

    public Integer count(int n) {
        Integer count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }
}