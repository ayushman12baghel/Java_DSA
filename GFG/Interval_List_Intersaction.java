//Approach 2 Pointers O(n+m)
class Solution {
    public List<List<Integer>> findIntersection(List<List<Integer>> arr1,
                                                List<List<Integer>> arr2) {
        
        int n=arr1.size();
        int m=arr2.size();
        
        List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        int j=0;
        
        while(i<n && j<m){
            int overlapStart=Math.max(arr1.get(i).get(0),arr2.get(j).get(0));
            int overlapEnd=Math.min(arr1.get(i).get(1),arr2.get(j).get(1));
            
            if(overlapEnd-overlapStart>=0){
                List<Integer> temp=new ArrayList<>();
                temp.add(overlapStart);
                temp.add(overlapEnd);
                ans.add(temp);
            }
            
            if(arr1.get(i).get(1)>=arr2.get(j).get(1)){
                j++;
            }else{
                i++;
            }
        }
        
        return ans;
    }
}
