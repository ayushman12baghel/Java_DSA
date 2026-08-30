class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n=l.length;
        
        int prefix[]=new int[n];
        prefix[0]=r[0]-l[0]+1;
        
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(r[i]-l[i]+1);
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<rank.length;i++){
            int left=0;
            int right=n-1;
            int target=rank[i];
            int intervalIndex=0;
            
            while(left<=right){
                int mid=left+(right-left)/2;
                
                if(prefix[mid]>=target){
                    intervalIndex=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            
            int markBefore=(intervalIndex>0?prefix[intervalIndex-1]:0);
            
            int offset=rank[i]-markBefore-1;
            ans.add(l[intervalIndex]+offset);
        }
        
        return ans;
    }
}
