//Approach O(logn)
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path=new ArrayList<>();
        int level=1;

        while((1<<level)<=label){
            level++;
        }

        while(label!=1){
            path.add(label);
            int parentMax=(1<<(level-1))-1;
            int parentMin=(1<<(level-2));

            int normalParent=label/2;
            label=parentMax+parentMin-normalParent;
            level--;
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }
}
