import java.util.*;

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]==b[0]?b[1]-a[1]:b[0]-a[0]));
        
        solve(root,target,k,pq);
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        
        return ans;
    }
    
    public void solve(Node root,int target,int k,PriorityQueue<int[]> pq){
        if(root==null){
            return;
        }
        
        solve(root.left,target,k,pq);
        
        int val=Math.abs(target-root.data);
        if(pq.size()<k || (!pq.isEmpty() && pq.peek()[0]>val)){
            pq.offer(new int[]{val,root.data});
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        solve(root.right,target,k,pq);
    }
}