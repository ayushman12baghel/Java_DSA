import java.util.*;

//Approach Using BFS O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=8;i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            int current=queue.poll();

            if(current>=low && current<=high){
                ans.add(current);
            }

            int ld=current%10;

            if(ld!=9){
                queue.offer(current*10+(ld+1));
            }
        }

        return ans;
    }
}
