import java.util.*;

// Approach 1 Using Binary Search on Ans O(klogn)
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int left = 0;
        int right = n / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossible(List<Integer> nums, int k) {
        int n = nums.size();

        int currentLength = 1;
        int prevLength = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                currentLength++;
            } else {
                prevLength = currentLength;
                currentLength = 1;
            }

            if (currentLength >= 2 * k) {
                return true;
            }

            if (Math.min(currentLength, prevLength) >= k) {
                return true;
            }
        }

        return false;
    }
}

//Approach 2 O(n)
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();

        int currentLength=1;
        int prevLength=0;
        int maxK=0;

        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                currentLength++;
            }else{
                prevLength=currentLength;
                currentLength=1;
            }

            maxK=Math.max(maxK,currentLength/2);
            maxK=Math.max(maxK,Math.min(currentLength,prevLength));
        }

        return maxK;
    }
}