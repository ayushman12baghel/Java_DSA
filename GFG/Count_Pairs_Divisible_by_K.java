//Approach Using HashMap O(n)
class Solution {
    public int countKdivPairs(int nums[], int k) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int remainder=nums[i]%k;
            
            int target=remainder==0?0:k-remainder;
            
            count+=map.getOrDefault(target,0);
            
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        
        return count;
    }
}
