//Approach O(nlogn)
class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;

        int gcd[]=new int[n];
        gcd[0]=nums[0];
        int max=nums[0];

        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            gcd[i]=gcd(nums[i],max);
        }

        Arrays.sort(gcd);

        int i=0;
        int j=n-1;

        long total=0;

        while(i<j){
            total+=gcd(gcd[i],gcd[j]);
            i++;
            j--;
        }

        return total;
    }

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}
}
