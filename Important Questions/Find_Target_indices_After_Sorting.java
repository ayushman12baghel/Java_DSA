//Approach 1 O(nlogn) Sorting
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
            }
        }

        return  ans;
    }
}

//Approach 2 O(n) Greedy Counting
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count1=0;
        int count2=0;

        for(int num:nums){
            if(num<target){
                count1++;
            }else if(num==target){
                count2++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=count1;i<count1+count2;i++){
            ans.add(i);
        }

        return ans;
    }
}

//Approach 3 O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count=0;

        for(int num:nums){
            if(num<target){
                count++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(count++);
            }
        }

        return ans;
    }
}
