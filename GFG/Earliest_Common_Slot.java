//Approach Using Sorting and Two Pointers O(nlogn+nlogm)
class Solution {
    public ArrayList<Integer> commonSlot(int[][] slots1, int[][] slots2, int d) {
        int n=slots1.length;
        int m=slots2.length;
        
        Arrays.sort(slots1,(a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);
        
        int i=0;
        int j=0;
        
        while(i<n && j<m){
            int overlapStart=Math.max(slots1[i][0],slots2[j][0]);
            int overlapEnd=Math.min(slots1[i][1],slots2[j][1]);
            
            if(overlapEnd-overlapStart>=d){
                ArrayList<Integer> ans=new ArrayList<>();
                ans.add(overlapStart);
                ans.add(overlapStart+d);
                return ans;
            }else{
                if(slots1[i][1]>slots2[j][1]){
                    j++;
                }else{
                    i++;
                }
            }
        }
        
        return new ArrayList<>();
    }
}
