//Approach 1 Using Memoisation T.L.E O(n^2)
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n=r.length;
        
        int nums[][]=new int[n][2];
        
        for(int i=0;i<n;i++){
            nums[i][0]=r[i];
            nums[i][1]=h[i];
        }
        
        Arrays.sort(nums,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        int dp[][]=new int[n][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(nums,0,-1,dp);
    }
    
    public int solve(int nums[][],int index,int prev,int dp[][]){
        if(index>=nums.length){
            return 0;
        }
        
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        
        int take=0;
        if(prev==-1 || (nums[index][0]>nums[prev][0] && nums[index][1]>nums[prev][1])){
            take=nums[index][1]+solve(nums,index+1,index,dp);
        }
        
        int skip=solve(nums,index+1,prev,dp);
        
        return dp[index][prev+1]=Math.max(take,skip);
    }
}

//Approach 2 Tabulation O(n^2)  T.L.E
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n=r.length;
        
        int nums[][]=new int[n][2];
        
        for(int i=0;i<n;i++){
            nums[i][0]=r[i];
            nums[i][1]=h[i];
        }
        
        Arrays.sort(nums,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        int dp[]=new int[n];
        dp[0]=nums[0][1];
        int ans=dp[0];
        
        for(int i=0;i<n;i++){
            dp[i]=nums[i][1];
            
            for(int j=0;j<i;j++){
                if(nums[i][0]>nums[j][0] && nums[i][1]>nums[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+nums[i][1]);
                }
                
                ans=Math.max(ans,dp[i]);
            }
        }
        
        return ans;
    }
}

//Approach 3 Using TreeMap O(nlogn)
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n=r.length;
        
        int nums[][]=new int[n][2];
        
        for(int i=0;i<n;i++){
            nums[i][0]=r[i];
            nums[i][1]=h[i];
        }
        
        Arrays.sort(nums,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);
        int ans=nums[0][1];
        
        for(int i=0;i<n;i++){
            int current=nums[i][1];
            
            Map.Entry<Integer,Integer> entry=map.lowerEntry(current);
            
            int newHeight=current+entry.getValue();
            
            ans=Math.max(newHeight,ans);
            
            entry=map.ceilingEntry(current);
            
            while(entry!=null && entry.getValue()<=newHeight){
                map.remove(entry.getKey());
                entry=map.ceilingEntry(current);
            }
            
            map.put(current,newHeight);
        }
        
        return ans;
    }
}

//Approach 4 Using Segment Tree O(nlogn)
class Solution {
    int tree[];
    
    public void init(int n){
        tree=new int[4*n];
    }
    
    public int getMax(int maxHeight,int qi,int qj){
        if(qi>qj){
            return 0;
        }
        
        return getMaxUtil(0,0,maxHeight,qi,qj);
    }
    
    public int getMaxUtil(int i,int si,int sj,int qi,int qj){
        if(qj<si || qi>sj){
            return 0;
        }else if(si>=qi && sj<=qj){
            return tree[i];
        }else{
            int mid=(si+sj)/2;
            int left=getMaxUtil(2*i+1,si,mid,qi,qj);
            int right=getMaxUtil(2*i+2,mid+1,sj,qi,qj);
            
            return Math.max(left,right);
        }
    }
    
    public void update(int maxHeight,int index,int value){
        updateUtil(0,0,maxHeight,index,value);
    }
    
    public void updateUtil(int i,int si,int sj,int index,int value){
        if(index>sj || index<si){
            return;
        }
        
        if(si==sj){
            tree[i]=Math.max(tree[i],value);
            return;
        }
        
        int mid=(si+sj)/2;
        updateUtil(2*i+1,si,mid,index,value);
        updateUtil(2*i+2,mid+1,sj,index,value);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    
    public int maxStackHeight(int[] r, int[] h) {
        int n=r.length;
        
        int nums[][]=new int[n][2];
        int maxHeight=0;
        
        for(int i=0;i<n;i++){
            nums[i][0]=r[i];
            nums[i][1]=h[i];
            maxHeight=Math.max(maxHeight,h[i]);
        }
        
        Arrays.sort(nums,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        init(maxHeight+1);
        int ans=0;
        
        for(int i=0;i<n;i++){
            int current=nums[i][1];
            
            int best=getMax(maxHeight,0,current-1);
            int newHeight=current+best;
            ans=Math.max(ans,newHeight);
            update(maxHeight,current,newHeight);
        }
        
        return ans;
    }
}
