class Solution {
    int original[];
    int current[];
    public Solution(int[] nums) {
        original=nums.clone();
        current=nums.clone();
    }
    
    public int[] reset() {
        current=original.clone();

        return current;
    }
    
    public int[] shuffle() {
        for(int i=0;i<current.length;i++){
            int j=i+(int)(Math.random()*(current.length-i));
            int temp=current[i];
            current[i]=current[j];
            current[j]=temp;
        }

        return current;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
