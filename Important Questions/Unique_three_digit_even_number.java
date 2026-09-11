//Approach 1 O(n^3) Brute Force 
class Solution {
    public int totalNumbers(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i==j || j==k || i==k){
                        continue;
                    }

                    int num=nums[i]*100+nums[j]*10+nums[k];

                    if(num>=100 && num%2==0){
                        set.add(num);
                    }
                }
            }
        }

        return set.size();
    }
}

//Approach 2 O(n)
class Solution {
    public int totalNumbers(int[] digits) {
        int result =0;
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) continue;
                freq[j]--;

                for (int k = 0; k <= 8; k += 2) {
                    if (freq[k] == 0) continue;
                    freq[k]--;

                    int num = i * 100 + j * 10 + k;
                    result++;

                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }

        return result;
    }
}
