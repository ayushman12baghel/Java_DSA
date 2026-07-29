//O(n)
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node curr=queue.poll();


            while(curr!=null){
                ans.add(curr.data);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                
                curr=curr.right;
            }
        }
        
        return ans;
    }
}
