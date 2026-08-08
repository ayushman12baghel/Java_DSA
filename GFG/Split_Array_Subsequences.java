//Approach 1 Using HashMap O(n)
class Solution {
    public boolean isPossible(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        Map<Integer,Integer> append=new HashMap<>();
        
        for(int num:nums){
            if(map.get(num)==0){
                continue;
            }
            
            if(append.getOrDefault(num-1,0)>0){
                map.put(num,map.get(num)-1);
                append.put(num-1,append.get(num-1)-1);
                append.put(num,append.getOrDefault(num,0)+1);
            }else{
                for(int i=0;i<k;i++){
                    if(map.getOrDefault(num+i,0)==0){
                        return false;
                    }
                    
                    map.put(num+i,map.get(num+i)-1);
                }
                
                append.put(num+k-1,append.getOrDefault(num+k-1,0)+1);
            }
        }
        
        return true;
    }
}

//Approach 2 O(nlogn) Using PriorityQueue
class Solution {
    public boolean isPossible(int[] nums, int k) {
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();

        for(int num:nums){
            if(map.containsKey(num-1) && !map.get(num-1).isEmpty()){
                int shortestLength=map.get(num-1).poll();
                map.putIfAbsent(num,new PriorityQueue<>());
                map.get(num).offer(shortestLength+1);
            }else{
                map.putIfAbsent(num,new PriorityQueue<>());
                map.get(num).offer(1);
            }
        }

        for(PriorityQueue<Integer> pq:map.values()){
            while(!pq.isEmpty()){
                if(pq.poll()<k){
                    return false;
                }
            }
        }

        return true;
    }
}
