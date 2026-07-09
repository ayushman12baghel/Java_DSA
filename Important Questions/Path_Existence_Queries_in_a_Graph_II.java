import java.util.*;

//Approach 1 DSU O(n)
class Solution {
    class DSU{
        int parent[];
        int size[];

        public DSU(int n){
            this.parent=new int[n];
            this.size=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int i){
            if(i==parent[i]){
                return i;
            }

            return parent[i]=find(parent[i]);
        }

        public void union(int x,int y){
            int parentX=find(x);
            int parentY=find(y);

            if(parentX==parentY){
                return;
            }

            if(size[parentX]>size[parentY]){
                parent[parentY]=parentX;
                size[parentX]+=size[parentY];
            }else{
                parent[parentX]=parentY;
                size[parentY]+=size[parentX];
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu=new DSU(n);

        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                dsu.union(i,i-1);
            }
        }

        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            if(dsu.find(queries[i][0])==dsu.find(queries[i][1])){
                ans[i]=true;
            }
        }

        return ans;
    }
}

//Approach 2 O(n)
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int components[]=new int[n];
        int current=0;
        components[0]=0;

        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                components[i]=components[i-1];
            }else{
                current++;
                components[i]=current;
            }
        }

        boolean ans[]=new boolean[queries.length];

        for(int i=0;i<queries.length;i++){
            if(components[queries[i][0]]==components[queries[i][1]]){
                ans[i]=true;
            }
        }

        return ans;
    }
}
