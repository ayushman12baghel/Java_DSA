//Approach O(nlogn)
class Solution {
    public int countMinOperations(int nums[]) {
        
        int count=0;
        int maxMultiply=0;
        
        for(int num:nums){
            int temp[]=getCount(num);
            count+=temp[1];
            maxMultiply=Math.max(maxMultiply,temp[0]);
        }
        
        return count+maxMultiply;
    }
    
    public int[] getCount(int n){
        int add=0;
        int multiply=0;
        
        while(n>1){
            if((n&1)==1){
                add++;
                n--;
            }else{
                n/=2;
                multiply+=1;
            }
        }
        
        if(n==1){
            add++;
        }
        
        return new int[]{multiply,add};
    }
}
