//Approach Using DFS O(n)
class Solution {
    int result;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1){
                continue;
            }

            graph.get(i).add(edges[i]);
        }

        int count[]=new int[n];
        boolean visited[]=new boolean[n];
        boolean inRecursion[]=new boolean[n];
        Arrays.fill(count,1);

        result=-1;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,count,visited,inRecursion,i);
            }
        }

        return result;
    }

    public void dfs(List<List<Integer>> graph,int count[],boolean visited[],boolean inRecursion[],int curr){
        visited[curr]=true;
        inRecursion[curr]=true;

        for(int neighbour:graph.get(curr)){
            if(!visited[neighbour]){
                count[neighbour]+=count[curr];
                dfs(graph,count,visited,inRecursion,neighbour);
            }else if(inRecursion[neighbour]){
                result=Math.max(count[curr]-count[neighbour]+1,result);
            }
        }

        inRecursion[curr]=false;
    }
}

//Approach 2 Kahn Algo O(n)
class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        List<List<Integer>> graph=new ArrayList<>();
        int indeg[]=new int[n];

        for(int i=0;i<edges.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1){
                continue;
            }

            graph.get(i).add(edges[i]);
            indeg[edges[i]]++;
        }

        boolean visited[]=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        int result=-1;

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                queue.offer(i);
                visited[i]=true;
            }
        }

        while(!queue.isEmpty()){
            int current=queue.poll();

            for(int neighbour:graph.get(current)){
                indeg[neighbour]--;
                if(indeg[neighbour]==0){
                    queue.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int current=i;
                int count=0;

                while(!visited[current]){
                    count++;
                    visited[current]=true;

                    for(int neighbour:graph.get(current)){
                        if(indeg[neighbour]>0){
                            current=neighbour;
                            break;
                        }
                    }
                }

                result=Math.max(result,count);
            }
        }

        return result;
    }
}
