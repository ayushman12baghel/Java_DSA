class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] nums) {
        int n=nums.length;
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        if(nums.length==0){
            return ans;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                int current=queue.poll();
                
                temp.add(nums[current]);
                
                if(2*current+1<n){
                    queue.offer(2*current+1);
                }
                
                if(2*current+2<n){
                    queue.offer(2*current+2);
                }
            }
            
            Collections.sort(temp);
            ans.add(temp);
        } 
        
        return ans;
    }
}
