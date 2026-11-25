//Approach Using Binary Search and Rolling Hash O(nlogn)
class Solution {
    long mod=1000000007;
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length;

        int left=1;
        int right=n;
        int result=n;
        int max=nums[0];
        for(int num:nums){
            max=Math.max(max,num);
        }
        max+=1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(isPossible(nums,mid,max)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return result;
    }

    public boolean isPossible(int nums[],int length,int max){
        Map<Long,Integer> map=new HashMap<>();   
        long p=findPower(max,length-1);
        
        int i=0;
        int j=0;
        long hash=0;

        while(j<nums.length){
            hash=(hash*max+nums[j])%mod;
            if(j-i+1<length){
                j++;
            }else{
                map.put(hash,map.getOrDefault(hash,0)+1);

                hash=(hash-(p*nums[i])%mod+mod)%mod;
                j++;
                i++;
            }
        }

        for(int value:map.values()){
            if(value==1){
                return true;
            }
        }

        return false;
    }

    public long findPower(int a,int b){
        if(b==0){
            return 1;
        }

        long half=findPower(a,b/2);
        long result=(half*half)%mod;

        if(b%2!=0){
            result=(result*a)%mod;
        }

        return result;
    }
}
