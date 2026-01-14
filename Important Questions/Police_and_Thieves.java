import java.util.*;

//Approach 1 O(n) with O(n) space
class Solution {
    public int catchThieves(char[] nums, int k) {
        int n = nums.length;

        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 'P') {
                police.add(i);
            } else {
                thief.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < police.size() && j < thief.size()) {
            if (Math.abs(police.get(i)) - thief.get(j) <= k) {
                count++;
                i++;
                j++;
            } else if (police.get(i) < thief.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}

// Approach 2 Using Two Pointer Algo O(n)
class Solution {
    public int catchThieves(char[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n && j < n) {
            while (i < n && nums[i] != 'P') {
                i++;
            }

            while (j < n && nums[j] != 'T') {
                j++;
            }

            if (i < n && j < n) {
                if (Math.abs(i - j) <= k) {
                    count++;
                    i++;
                    j++;
                } else if (i < j) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}