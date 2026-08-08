//Approach 1 By Finding Farthest Node and Simulating 
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int farthestFrom0[]=bfs(graph,0);
        int farthestNodeA=getFarthest(farthestFrom0);

        int farthestFromA[]=bfs(graph,farthestNodeA);
        int farthestNodeB=getFarthest(farthestFromA);

        int farthestFromB[]=bfs(graph,farthestNodeB);

        int height[]=new int[n];
        int minHeight=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currentHeight=Math.max(farthestFromA[i],farthestFromB[i]);
            minHeight=Math.min(minHeight,currentHeight);
            height[i]=currentHeight;
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(height[i]==minHeight){
                ans.add(i);
            }
        }

        return ans;
    }

    public int[] bfs(List<List<Integer>> graph,int start){
        int dist[]=new int[graph.size()];
        Arrays.fill(dist,-1);
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        dist[start]=0;

        while(!queue.isEmpty()){
            int current=queue.poll();

            for(int neighbour:graph.get(current)){
                if(dist[neighbour]==-1){
                    queue.offer(neighbour);
                    dist[neighbour]=dist[current]+1;
                }
            }
        }

        return dist;
    }

    public int getFarthest(int nums[]){
        int farthestIndex=0;
        int maxHeight=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxHeight){
                maxHeight=nums[i];
                farthestIndex=i;
            }
        }

        return farthestIndex;
    }
}
