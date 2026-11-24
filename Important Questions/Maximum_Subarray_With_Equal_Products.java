//Approach Brute Force O(n^2*logn)
class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;

        int ans=0;

        for(int i=0;i<n;i++){
            int prod=nums[i];
            int gcdProd=nums[i];
            int lcmProd=nums[i];
            for(int j=i+1;j<n;j++){
                prod=prod*nums[j];
                gcdProd=gcd(gcdProd,nums[j]);
                lcmProd=(lcmProd*nums[j])/gcd(lcmProd,nums[j]);

                if(prod>gcdProd*lcmProd){
                    break;
                }

                if(gcdProd*lcmProd==prod){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }

        return ans;
    }

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
}

//Approach 2 Using Sliding  Window O(nlogn)
class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;

        int ans=2;  
        int prod=1;
        int i=0;
        int j=0;

        while(j<n){
            while(gcd(prod,nums[j])>1){
                prod/=nums[i];
                i++;
            }

            prod*=nums[j];
            ans=Math.max(ans,j-i+1);

            j++;
        }

        return ans;
    }

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
}
